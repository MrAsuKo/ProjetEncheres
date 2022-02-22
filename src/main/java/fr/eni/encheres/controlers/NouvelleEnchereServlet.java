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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.User;
import fr.eni.encheres.bo.Vente;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class NouvelleEnchereServlet
 */
@WebServlet("/NouvelleEnchere")
public class NouvelleEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VenteMgr venteMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleEnchereServlet() {
        super();
        venteMgr = new VenteMgr();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DetailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String offreStr = request.getParameter("offre");
		String noArticleStr = request.getParameter("noArticle");
		int noArticle = Integer.parseInt(noArticleStr);
		request.setAttribute("noArticleStr", noArticleStr);
				//Creation de la liste des encheres
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
				//fin de la creation de la liste des encheres
		int offre = Integer.parseInt(offreStr);
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		venteMgr.offreEnchere(offre,noArticle,id);
		//recuperer la meilleur offre
		Enchere enchere = null;
		try {
			enchere = venteMgr.meilleurOffre(noArticle);
		} catch (fr.eni.encheres.dal.DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("meilleurOffre", enchere.getMontantEnchere());
		doGet(request, response);
	}

}
