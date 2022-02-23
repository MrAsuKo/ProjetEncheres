package fr.eni.encheres.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.CategorieMgr;
import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Articles_vendus;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/EnregistrerNouvelleVente")
public class EnregistrerNouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//attribu vers Manager
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerNouvelleVenteServlet() {
        super();
        categorieMgr = new CategorieMgr();
        venteMgr = new VenteMgr();;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				//liste des categories
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
				
		String nom_article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorieStr = request.getParameter("categorie");
		Categorie categorie = new Categorie(Integer.parseInt(categorieStr));
		String prixdepartStr = request.getParameter("prixdepart");
		String debutenchereStr = request.getParameter("debutenchere");
		String finenchereStr = request.getParameter("finenchere");
		int numcategorie = Integer.parseInt(categorieStr);
		int no_utilisateur = (int) request.getSession(false).getAttribute("id");
//		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		Utilisateur utilisateur = new Utilisateur(no_utilisateur);
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		LocalDate date_debut_encheres = LocalDate.parse(debutenchereStr);
		LocalDate date_fin_encheres = LocalDate.parse(finenchereStr);
		int prixdepart = Integer.parseInt(prixdepartStr);
		
		try {
		int noArticle = venteMgr.ajoutEnchere(nom_article, description, date_debut_encheres, date_fin_encheres, prixdepart,utilisateur,categorie);
		System.out.println(noArticle);
		venteMgr.insertRetrait(noArticle,rue,cp,ville);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
