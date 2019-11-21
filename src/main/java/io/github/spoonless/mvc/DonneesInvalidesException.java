package io.github.spoonless.mvc;

public class DonneesInvalidesException extends Exception {
	
	private ErreursDonneesPersonnelles erreurs;

	public DonneesInvalidesException(ErreursDonneesPersonnelles erreurs) {
		this.erreurs = erreurs;
	}
	
	public ErreursDonneesPersonnelles getErreurs() {
		return erreurs;
	}

}
