package ni;

import java.util.Date;

public class Utilisateur {
	private Integer id;
	private String login;
	private Date inscription;
	private boolean actif;

	public Utilisateur(int id, String login, Date dateInscription, boolean actif) {
		this(login, dateInscription, actif);
		this.id = id;
	}

	public Utilisateur(String login, Date dateInscription, boolean actif) {
		this.login = login;
		this.inscription = dateInscription;
		this.actif = actif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getInscription() {
		return inscription;
	}

	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

}