package io.github.spoonless.mvc.modele;

public class DonneesInvalidesException extends Exception {
	
	private ErreursDonneesPersonnelles erreurs;

	public DonneesInvalidesException(ErreursDonneesPersonnelles erreurs) {
		this.erreurs = erreurs;
	}
	
	public ErreursDonneesPersonnelles getErreurs() {
		return erreurs;
	}

}
