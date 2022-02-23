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
import fr.eni.encheres.bo.Articles_vendus;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class FiltreRechercheCategoriesServlet
 */
@WebServlet("/FiltreRecherche")
public class FiltreRechercheCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategorieMgr categorieMgr;
	private VenteMgr venteMgr;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FiltreRechercheCategoriesServlet() {
		super();
		categorieMgr = new CategorieMgr();
		venteMgr = new VenteMgr();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// liste des categoeries
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
		// fin list des categories

		String categStr = request.getParameter("categorie");
		String contient = request.getParameter("contient");
		int no_categorie = Integer.parseInt(categStr);
		if (!categStr.equals("0")) {
			System.out.println(no_categorie);
			// Creation de la liste des encheres par categoeries choisi
			List<Articles_vendus> listeEnchere = null;
			try {
				listeEnchere = venteMgr.selectencherecateg(no_categorie);
			} catch (fr.eni.encheres.dal.DALException e) {
				e.printStackTrace();
			}
			request.setAttribute("listeEnchere", listeEnchere);
			// fin de la creation de la liste des encheres
		} else {
			// Creation de la liste des encheres par mot choisi
			List<Articles_vendus> listeEnchere = null;
			try {
				listeEnchere = venteMgr.selectEnchereContient(contient);
			} catch (fr.eni.encheres.dal.DALException e) {

				e.printStackTrace();
			}
			request.setAttribute("listeEnchere", listeEnchere);
		}
		// fin de la creation de la liste des encheres

		doGet(request, response);
	}

}
