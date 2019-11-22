package ni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilisateurDao {

	private Connection connection;

	public UtilisateurDao(Connection c) {
		this.connection = c;
	}

	public void desactiverAnciensUtilisateurs() throws SQLException {
		try (Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("update Utilisateur " + "set actif = 0 "
					+ "where year(dateInscription) < year(current_date) - 10 ");
		}
	}

	public List<Utilisateur> getUtilisateurs() throws SQLException {
		String request = "select id, login, dateInscription, actif from Utilisateur";
		List<Utilisateur> utilisateurs = new ArrayList<>();

		try (Statement stmt = connection.createStatement(); 
		     ResultSet resultSet = stmt.executeQuery(request);) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String login = resultSet.getString("login");
				Date dateInscription = resultSet.getDate("dateInscription");
				boolean actif = resultSet.getBoolean("actif");
				
				Utilisateur u = new Utilisateur(id, login, dateInscription, actif);
				utilisateurs.add(u);
			}
		}
		
		return utilisateurs;
	}
	
	public boolean isAutorise(String login, String droit) throws SQLException {
		String requete = "select count(1) from Utilisateur u "
				       + "inner join Utilisateur_Droit ud on ud.id_utilisateur = u.id "
				       + "inner join Droit d on d.id = ud.id_droit "
				       + "where u.login = ? "
				       + "and d.libelle = ? "
				       + "and u.actif = 1";
		try(PreparedStatement pstmt = connection.prepareStatement(requete)) {
			pstmt.setString(1, login);
			pstmt.setString(2, droit);
			try(ResultSet resultSet = pstmt.executeQuery()) {
				resultSet.next();
				int nbLignes = resultSet.getInt(1);
				return nbLignes != 0;
			}
		}
	}
	
	public void ajouter(Utilisateur utilisateur, String... noms) throws SQLException {
		boolean isOk = false;
		connection.setAutoCommit(false);
		try {
			insertUtilisateur(utilisateur);
			insertDroits(utilisateur, noms);
			isOk = true;
		} finally {
			if (isOk) {
				connection.commit();
			} else {
				connection.rollback();
			}
		}
	}

	private void insertDroits(Utilisateur utilisateur, String... noms) throws SQLException {
		String requeteDroit = "insert into Utilisateur_Droit (id_utilisateur, id_droit) "
				            + "select ?, d.id from Droit d where d.libelle = ?";
		try(PreparedStatement stmt = connection.prepareStatement(requeteDroit)) {
			stmt.setInt(1, utilisateur.getId());
			for (String nomDroit : noms) {
				stmt.setString(2, nomDroit);
				stmt.executeUpdate();
			}
		}
	}

	private void insertUtilisateur(Utilisateur utilisateur) throws SQLException {
		String requeteInsertionUtilisateur = "insert into Utilisateur (login, dateInscription, actif) "
				                           + "values (?, ?, ?)";
		// Insérer utilisateur
		try(PreparedStatement stmt = connection.prepareStatement(requeteInsertionUtilisateur, 
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, utilisateur.getLogin());
			stmt.setDate(2, new java.sql.Date(utilisateur.getInscription().getTime()));
			stmt.setBoolean(3, utilisateur.isActif());
			
			stmt.executeUpdate();
			utilisateur.setId(extractPrimaryKey(stmt));
		}
	}

	private int extractPrimaryKey(PreparedStatement stmt) throws SQLException {
		try(ResultSet resultSet = stmt.getGeneratedKeys()) {
			if(! resultSet.next()) {
				connection.rollback();
				throw new SQLException("Aucun utilisateur inséré !");
			}
			return resultSet.getInt(1);
		}
	}

}
