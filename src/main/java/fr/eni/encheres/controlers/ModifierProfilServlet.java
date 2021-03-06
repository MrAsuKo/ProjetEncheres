package fr.eni.encheres.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UserMgr;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ModifierProfil")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserMgr userMgr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfilServlet() {
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
		String mdp = request.getParameter("nouveau_mdp");
//		String mdp = request.getParameter("mdp");
//		String nouveau_mdp = request.getParameter("nouveau_mdp");
//		String mdp_conf = request.getParameter("mdp_conf");
		
//		if(mdp.equals(mdp_conf)) {
//			
//		}else {
//			String message = "Les mots de passes ne correspondent pas !";
//		request.setAttribute("message", message);
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp");
//		rd.forward(request, response);
//		 //throw new Exception("Probl???me d'authentification de mot de passe");
//		}		
	try {
		userMgr.modifUser(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp);

			Utilisateur user = userMgr.selectUser(pseudo, mdp);
			if(user.isTrouve()) {
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
				
				session.setAttribute("utilisateurConnecte", user);
			}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
		
		
//		
//		if(nouveau_mdp.equals(mdp_conf)) {
//			
//		try {
//			userMgr.modifUser(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp);
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp");
//			rd.forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}}else {
//			String message = "Les mots de passes ne correspondent pas !";
//		request.setAttribute("message", message);
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp");
//		rd.forward(request, response);
//	}
//}


