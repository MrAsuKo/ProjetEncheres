package fr.eni.gestion_user.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestion_user.bll.UserMgr;

/**
 * Servlet implementation class CreationUser
 */
@WebServlet("/CreationUser")
public class CreationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//attibut vers Manager
	private UserMgr userMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUserServlet() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		String mdpconf = request.getParameter("mdp_conf");

		
		// creer un message si les mdp snt différent
		if (mdpconf.equals(mdp)) {
			RequestDispatcher rd = request.getRequestDispatcher("/AccueilConnecter.jsp");
			rd.forward(request, response);
		}
		//si l'utilisateur se créer, on va sur la page d'accueil connectée
		else {
			String message = "les mdp ne corespondent pas";
			request.setAttribute("message", message);
			System.out.println(message);
			RequestDispatcher rd = request.getRequestDispatcher("/Inscription.jsp");
			rd.forward(request, response);
		}
	
			
		
		try {
			userMgr.ajouterUser(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdpconf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
