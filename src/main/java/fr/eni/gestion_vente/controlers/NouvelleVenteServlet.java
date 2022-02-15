package fr.eni.gestion_vente.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestion_vente.bll.VenteMgr;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVente")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//attribu vers Manager
	private VenteMgr venteMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleVenteServlet() {
        super();
        venteMgr= new VenteMgr();
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
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String catégorie = request.getParameter("catégorie");
		String prixdepart = request.getParameter("prixdepart");
		String debutenchere = request.getParameter("debutenchere");
		String finenchere = request.getParameter("finenchere");
		
		try {
		venteMgr.ajoutenchere(article, description, debutenchere, finenchere, prixdepart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
