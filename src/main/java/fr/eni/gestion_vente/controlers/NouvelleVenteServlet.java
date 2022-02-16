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

import org.apache.catalina.tribes.util.Arrays;

import fr.eni.gestion_user.bll.UserMgr;
import fr.eni.gestion_user.dal.DALException;
import fr.eni.gestion_vente.bll.CategorieMgr;
import fr.eni.gestion_vente.bo.Categorie;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVente")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CategorieMgr categorieMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleVenteServlet() {
        super();
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
			List<Categorie> listeCategorie = null;
			try {
				listeCategorie = categorieMgr.selectcategorie();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String catego1 = listeCategorie.get(0).toString();
		System.out.println(catego1);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);
	}
}