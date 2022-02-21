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
import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;

/**
 * Servlet implementation class CreationUser
 */
@WebServlet("/AccueilInscr")
public class CreationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//attibut vers Manager
	private UserMgr userMgr;
	private VenteMgr venteMgr;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUserServlet() {
        super();
        userMgr = new UserMgr();
        venteMgr = new VenteMgr();
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
			listeEnchere = venteMgr.selectenchere();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("listeEnchere", listeEnchere);
		//fin de la creation de la liste des encheres
		
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
			boolean use = userMgr.verifierUser(pseudo, email, mdp);
			if (use) {
			String message = "Pseudo et/ou email déja utilisés";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
			rd.forward(request, response);
			}
			if(mdpconf.equals(mdp) && use == false) {
			User user = userMgr.ajouterUser(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdpconf);
			HttpSession session = request.getSession();
			
			session.setAttribute("id", user.getId());
			session.setAttribute("pseudo", pseudo);
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
			String message = "Les mots de passe ne corespondent pas";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
			rd.forward(request, response);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
			}