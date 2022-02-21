package fr.eni.gestion_user.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gestion_user.bll.UserMgr;
import fr.eni.gestion_user.bo.User;
import fr.eni.gestion_vente.bll.CategorieMgr;
import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;

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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creation de la liste des encheres
		List<Vente> listeEnchere = null;		
		try {
			try {
				listeEnchere = venteMgr.selectenchere();
			} catch (fr.eni.gestion_user.dal.DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeEnchere", listeEnchere);
		//fin de la creation de la liste des encheres
		//liste des categoeries
		List<Categorie> listeCategorie = null;
		try {
			try {
				listeCategorie = categorieMgr.selectcategorie();
			} catch (fr.eni.gestion_user.dal.DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listecategorie", listeCategorie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fin list des categories
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
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
