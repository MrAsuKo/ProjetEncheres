package fr.eni.gestion_user.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gestion_user.bll.UserMgr;
import fr.eni.gestion_user.bo.User;

/**
 * Servlet implementation class CreationUser
 */
@WebServlet("/AccueilInscr")
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
		
		try {
			if(mdpconf.equals(mdp)) {
				User user = userMgr.ajouterUser(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdpconf);
				HttpSession session = request.getSession();
				session.setAttribute("pseudo", pseudo);
				session.setAttribute("id", user.getId());
				session.setAttribute("nom", user.getNom());
				session.setAttribute("prenom", user.getPrenom());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("telephone", user.getTelephone());
				session.setAttribute("rue", user.getRue());
				session.setAttribute("cp", user.getCp());
				session.setAttribute("ville", user.getVille());
				session.setAttribute("mdp", user.getMdp());
				session.setAttribute("credit", user.getCredit());
				session.setAttribute("administrateur", user.isAdministrateur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);
				String message = "Les mots de passe ne corespondent pas";
				request.setAttribute("message", message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
