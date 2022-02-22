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

import fr.eni.encheres.bll.CategorieMgr;
import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Vente;
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
				
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String prixdepart = request.getParameter("prixdepart");
		String debutenchere = request.getParameter("debutenchere");
		String finenchere = request.getParameter("finenchere");
		int numcategorie = Integer.parseInt(categorie);
		int id = (int) request.getSession(false).getAttribute("id");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		try {
		int noArticle = venteMgr.ajoutenchere(article, description, debutenchere, finenchere, prixdepart,id,numcategorie);
		venteMgr.insertretrait(noArticle,rue,cp,ville);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
