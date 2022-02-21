package fr.eni.encheres;

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
 * Servlet implementation class AccueilServlet
 */
@WebServlet({"/index.html","/Accueil"})
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VenteMgr venteMgr;
	private CategorieMgr categorieMgr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
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
		request.getSession().invalidate();
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
		
	}
}