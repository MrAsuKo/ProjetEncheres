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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import fr.eni.gestion_user.bo.User;
import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;

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
					listeEnchere = venteMgr.selectenchere();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(listeEnchere.get(0));
				request.setAttribute("listeEnchere", listeEnchere);
				//fin de la creation de la liste des encheres
		int offre = Integer.parseInt(offreStr);
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		//Inserer l'offre dans la BDD
		venteMgr.offreEnchere(offre,noArticle,id);
		//recuperer la meilleur offre
		int meilleurOffre = venteMgr.meilleurOffre();
		
		doGet(request, response);
	}

}
