package modernindustry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/log", loadOnStartup = 0)
public class LogServlet extends HttpServlet {

    private static final long serialVersionUID = 7446985734933559486L;

    @Override
    public void init() throws ServletException {
        System.out.println("################################# init " + getServletName());
    }

    @Override
    public void destroy() {
        System.out.println("################################# destroy " + getServletName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");
        resp.getWriter().write(getServletName() + " called successfully");
    }

}