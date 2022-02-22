package fr.eni.gestion_vente.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestion_vente.bll.CategorieMgr;
import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;

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
				
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String prixdepart = request.getParameter("prixdepart");
		String debutenchere = request.getParameter("debutenchere");
		String finenchere = request.getParameter("finenchere");
		int numcategorie = Integer.parseInt(categorie);
		int id = (int) request.getSession(false).getAttribute("id");
		
		try {
		venteMgr.ajoutenchere(article, description, debutenchere, finenchere, prixdepart,id,numcategorie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
