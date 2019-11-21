package io.github.spoonless.mvc;

public class DonneesPersonnelles {
	
	private Civilite civilite;
	private String nom;
	private Integer age;
	private String email;
	
	public DonneesPersonnelles(String civilite, String nom, String age, String email) throws DonneesInvalidesException {
		ErreursDonneesPersonnelles erreurs = new ErreursDonneesPersonnelles();
		if (isBlank(nom)) {
			erreurs.setErreurNom("Le nom est obligatoire !");
		}
		if(isNotBlank(email) && ! email.contains("@")) {
			erreurs.setErreurEmail("L'email n'est pas valide !");
		}
		if(isNotBlank(civilite)) {
			this.civilite = Civilite.valueOf(civilite);
		}
		this.nom = nom;
		this.age = convertirAge(age, erreurs); 
		this.email = email;
		
		if (erreurs.isPresent()) {
			throw new DonneesInvalidesException(erreurs);
		}
	}

	private int convertirAge(String age, ErreursDonneesPersonnelles erreurs) {
		try {
			if (isBlank(age)) {
				erreurs.setErreurAge("L'âge est obligatoire !");
				return 0;
			}
			int ageConverti = Integer.valueOf(age);
			if (ageConverti <= 0) {
				erreurs.setErreurAge("L'âge doit être supérieur à 0 !");
			}
			return ageConverti;
		} catch(NumberFormatException e) {
			erreurs.setErreurAge("L'âge n'est pas un nombre !");
			return 0;
		}
	}
	
	private static boolean isNotBlank(String valeur) {
		return ! isBlank(valeur);
	}
	
	private static boolean isBlank(String valeur) {
		return valeur == null || "".equals(valeur);
	}
	
	public Civilite getCivilite() {
		return civilite;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public boolean isMajeur() {
		return age != null && age >= 18;
	}
	
	public String getEmail() {
		return email;
	}
	
}



