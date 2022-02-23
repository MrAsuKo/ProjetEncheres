package fr.eni.encheres.controlers;

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

import fr.eni.encheres.bll.CategorieMgr;
import fr.eni.encheres.bll.UserMgr;
import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Articles_vendus;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class CreationUser
 */
@WebServlet("/AccueilInscr")
public class CreationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//attibut vers Manager
	private UserMgr userMgr;
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUserServlet() {
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
				List<Articles_vendus> listeEnchere = null;		
				try {
					try {
						listeEnchere = venteMgr.selectEnchere();
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
			Utilisateur user = userMgr.ajouterUser(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdpconf);
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