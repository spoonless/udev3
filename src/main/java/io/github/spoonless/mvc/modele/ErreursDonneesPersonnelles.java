package io.github.spoonless.mvc.modele;

public class ErreursDonneesPersonnelles {

	private String erreurNom;
	private String erreurAge;
	private String erreurEmail;
	
	public boolean isPresent() {
		return erreurNom != null || erreurAge != null || erreurEmail != null;
	}

	public String getErreurNom() {
		return erreurNom;
	}

	public void setErreurNom(String erreurNom) {
		this.erreurNom = erreurNom;
	}

	public String getErreurAge() {
		return erreurAge;
	}

	public void setErreurAge(String erreurAge) {
		this.erreurAge = erreurAge;
	}

	public String getErreurEmail() {
		return erreurEmail;
	}

	public void setErreurEmail(String erreurEmail) {
		this.erreurEmail = erreurEmail;
	}

}
