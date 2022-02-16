package fr.eni.gestion_user.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.gestion_user.bll.UserMgr;

/**
 * Servlet implementation class SupprimerUserServlet
 */
@WebServlet("/SupprimerUser")
public class SupprimerUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserMgr userMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUserServlet() {
        super();
        userMgr = new UserMgr();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = (String) request.getSession(false).getAttribute("pseudo");
		try {
			userMgr.supprimerUser(pseudo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}