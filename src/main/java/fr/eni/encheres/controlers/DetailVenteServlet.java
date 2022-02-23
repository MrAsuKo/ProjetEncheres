package fr.eni.encheres.controlers;

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

import fr.eni.encheres.bll.VenteMgr;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Articles_vendus;
import fr.eni.encheres.dal.DALException;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recuperer le pseudo par le lien
		String noArticleStr = request.getParameter("name");
		int noArticle = Integer.parseInt(noArticleStr);
		request.setAttribute("noArticleStr", noArticleStr);
		// Creation de la liste des encheres
		List<Articles_vendus> listeEnchere = null;
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
		// fin de la creation de la liste des encheres
		// recuperer la meilleur offre
		Enchere enchere = null;
		try {
			enchere = venteMgr.meilleurOffre(noArticle);

		} catch (fr.eni.encheres.dal.DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("meilleurOffre", enchere);

		// remporter enchrere si date fin est depassé
		String datefinStr = request.getParameter("datefin");
		LocalDate datefinDate = LocalDate.parse(datefinStr);
		if (datefinDate.isBefore(LocalDate.now())) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/EnchereFini.jsp");
			rd.forward(request, response);
			// va sur la page d'enchere
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DetailVente.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
