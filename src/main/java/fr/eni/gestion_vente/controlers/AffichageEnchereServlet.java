package fr.eni.gestion_vente.controlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestion_vente.bll.CategorieMgr;
import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Vente;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vente> listeEnchere = null;
		
		listeEnchere = VenteMgr.selectenchere();
		
		
		doGet(request, response);
	}

}
