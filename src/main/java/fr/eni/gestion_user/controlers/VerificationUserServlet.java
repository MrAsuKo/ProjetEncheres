package fr.eni.gestion_user.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestion_user.bll.UserMgr;
import fr.eni.gestion_user.bo.User;

/**
 * Servlet implementation class VerificationUserServlet
 */
@WebServlet("/VerificationUser")
public class VerificationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserMgr userMgr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationUserServlet() {
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
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		boolean mdpEtat;
		try {
			mdpEtat = userMgr.verifierUser(pseudo, mdp);
			System.out.println(mdpEtat);
			if(mdpEtat == true) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/SeConnecter.jsp");
				rd.forward(request, response);
				String message = "Mot de passe incorrect";
				request.setAttribute("message", message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}