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

import fr.eni.gestion_user.bll.UserMgr;
import fr.eni.gestion_vente.bll.CategorieMgr;
import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;

/**
 * Servlet implementation class BackAccueilServlet
 */
@WebServlet("/BackAccueil")
public class BackAccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserMgr userMgr;
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackAccueilServlet() {
        super();
        userMgr = new UserMgr();
        venteMgr = new VenteMgr();
        categorieMgr = new CategorieMgr();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecter.jsp");
		rd.forward(request, response); 
	}

}
