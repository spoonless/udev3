package modernindustry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String code = req.getParameter("code");
		String libelle = req.getParameter("libelle");

		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter w = resp.getWriter();
		w.append("<!DOCTYPE html>\n")
		 .append("<html>\n")
		 .append("<head>\n")
		 .append("<meta charset=\"UTF-8\">\n")
		 .append("<title>Formulaire Produit</title>\n")
		 .append("</head>\n")
		 .append("<body>\n")
		 .append("<p>").append(libelle).append("</p>")
		 .append("<img src=\"./barcode?type=datamatrix&msg=").append(code).append("\" >")
		 .append("</body>\n")
		 .append("</html>\n");

	}

}









