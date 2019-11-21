package io.github.spoonless.mvc.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.spoonless.mvc.modele.Civilite;
import io.github.spoonless.mvc.modele.DonneesInvalidesException;
import io.github.spoonless.mvc.modele.DonneesPersonnelles;

@WebServlet("/donneespersonnelles")
public class SaisieDonneesPersonnellesControleur extends HttpServlet {
	
	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/saisieDonneesPersonnelles.jsp";
	private static final String VUE_RESULTAT = "/WEB-INF/jsp/donneesPersonnelles.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		afficherFormulaire(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String civilite = req.getParameter("civilite");
			String nom = req.getParameter("nom");
			String age = req.getParameter("age");
			String email = req.getParameter("email");
			DonneesPersonnelles donneesPersonnelles = new DonneesPersonnelles(civilite, nom, age, email);
			req.setAttribute("donneesPersonnelles", donneesPersonnelles);
			getServletContext().getRequestDispatcher(VUE_RESULTAT).forward(req, resp);
		} catch (DonneesInvalidesException e) {
			req.setAttribute("erreurs", e.getErreurs());
			afficherFormulaire(req, resp);
		}
	}

	private void afficherFormulaire(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Civilite[] civilites = Civilite.values();
		req.setAttribute("civilites", civilites);
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	}
	
}
