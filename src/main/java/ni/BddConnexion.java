package ni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BddConnexion {

	private static final String JDBC_URL = "jdbc:mysql://10.142.140.211:3306/udev3";
	private static final String LOGIN = "david";
	private static final String PASSWORD = "david";

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		try(Connection c = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD)) {
			UtilisateurDao utilisateurDao = new UtilisateurDao(c);
			utilisateurDao.desactiverAnciensUtilisateurs();
			List<Utilisateur> utilisateurs = utilisateurDao.getUtilisateurs();
			for(Utilisateur u : utilisateurs) {
				System.out.printf("%2$s (ID : %1$d) inscrit depuis %3$td %3$tB %3$tY\n", 
						          u.getId(), u.getLogin(), u.getInscription());
			}
			
			boolean isAutorise = utilisateurDao.isAutorise("Spoonless", "lecture");
			System.out.println(isAutorise ? "Spoonless est autorisé" : "Spoonless n'est pas autorisé");

			isAutorise = utilisateurDao.isAutorise("Nounours", "lecture");
			System.out.println(isAutorise ? "Nounours est autorisé" : "Nounours n'est pas autorisé");

			isAutorise = utilisateurDao.isAutorise("Doe", "lecture");
			System.out.println(isAutorise ? "Doe est autorisé" : "Doe n'est pas autorisé");
			
			Utilisateur u = new Utilisateur("root", new Date(), true);
			utilisateurDao.ajouter(u, "lecture", "suppression");
		}
		
	}

}
