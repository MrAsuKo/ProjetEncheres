package fr.eni.encheres.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.CategorieMgr;
import fr.eni.encheres.bll.UserMgr;
import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.User;
import fr.eni.encheres.bo.Vente;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class VerificationUserServlet
 */
@WebServlet("/AccueilConnect")
public class VerificationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserMgr userMgr;
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationUserServlet() {
        super();
        userMgr = new UserMgr();
        venteMgr = new VenteMgr();
        categorieMgr = new CategorieMgr();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//liste des categoeries
		List<Categorie> listeCategorie = null;
		try {
			try {
				listeCategorie = categorieMgr.selectcategorie();
			} catch (fr.eni.encheres.dal.DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listecategorie", listeCategorie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fin list des categories
		//Creation de la liste des encheres
		List<Vente> listeEnchere = null;		
		try {
			try {
				listeEnchere = venteMgr.selectenchere();
			} catch (fr.eni.encheres.dal.DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeEnchere", listeEnchere);
		//fin de la creation de la liste des encheres

		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		//cookie se souvenir
		if (request.getParameter("memoriser") != null) {
			Cookie cookie = new Cookie("identite",pseudo);
			cookie.setHttpOnly(true);
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setComment("souvenir");
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("identite", pseudo);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		// crée la session
		try {
			User user = userMgr.selectUser(pseudo, mdp);
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
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
				rd.forward(request, response); 
			} else {
				String message = "Pseudo ou mot de passe incorrect";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/SeConnecter.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		}
	
}
