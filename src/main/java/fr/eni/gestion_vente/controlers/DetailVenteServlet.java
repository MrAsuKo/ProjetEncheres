package fr.eni.gestion_vente.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestion_vente.bll.VenteMgr;
import fr.eni.gestion_vente.bo.Enchere;
import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;

/**
 * Servlet implementation class DetailVenteServlet
 */
@WebServlet("/DetailVente")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private VenteMgr venteMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailVenteServlet() {
        super();
        venteMgr = new VenteMgr();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noArticleStr = request.getParameter("name");
		String datefin = request.getParameter("datefin");
		int noArticle = Integer.parseInt(noArticleStr);
		request.setAttribute("noArticleStr", noArticleStr);
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
		//recuperer la meilleur offre
		Enchere enchere = null;
		try {
			enchere = venteMgr.meilleurOffre(noArticle);
		} catch (fr.eni.gestion_user.dal.DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" test : " + enchere.getId());
		request.setAttribute("meilleurOffre", enchere.getOffre());
		request.setAttribute("id", enchere.getId());
		request.setAttribute("pseudo", enchere.getPseudo());
		
		//remporter enchrere si date fin est depassé
		LocalDate datefinDate = LocalDate.parse(datefin);
		if(datefinDate.isBefore(LocalDate.now())) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/EnchereFini.jsp");
		rd.forward(request, response);
		// va sur la page d'enchere
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DetailVente.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
