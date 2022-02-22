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
import fr.eni.encheres.bo.Vente;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class AffichageEnchereServlet
 */
@WebServlet("/AffichageEnchere")
public class AffichageEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private VenteMgr venteMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageEnchereServlet() {
        super();
        venteMgr = new VenteMgr();
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
		List<Vente> listeEnchere = null;		
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
		
		doGet(request, response);
	}

}
