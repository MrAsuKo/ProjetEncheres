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
import fr.eni.encheres.bll.UserMgr;
import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Articles_vendus;
import fr.eni.encheres.bo.Categorie;

/**
 * Servlet implementation class AnnulerVenteServlet
 */
@WebServlet("/CancelBackAccueil")
public class AnnulerVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMgr userMgr;
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnulerVenteServlet() {
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
		String noArticle = request.getParameter("noArticle");
		int no_article = Integer.parseInt(noArticle);
		try {
			venteMgr.supprimerVente(no_article);
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
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}