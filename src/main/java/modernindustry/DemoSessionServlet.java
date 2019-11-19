package modernindustry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoSessionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametre = req.getParameter("parametre");
		if (parametre != null) {
			req.getSession().setAttribute("parametre", parametre);
		} else {
			parametre = (String) req.getSession().getAttribute("parametre");
		}
		
		resp.setContentType("text/plain");
		resp.getWriter().append(parametre);
	}

}
