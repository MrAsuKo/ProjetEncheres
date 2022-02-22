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
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Vente;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class CheckboxFiltreServlet
 */
@WebServlet("/CheckboxFiltre")
public class CheckboxFiltreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserMgr userMgr;
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckboxFiltreServlet() {
        super();
        userMgr = new UserMgr();
        venteMgr = new VenteMgr();
        categorieMgr = new CategorieMgr();
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
				
		doGet(request, response);
	}

}
