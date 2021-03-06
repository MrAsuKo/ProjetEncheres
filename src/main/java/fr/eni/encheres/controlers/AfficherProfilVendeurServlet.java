package fr.eni.encheres.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UserMgr;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class AfficherProfilVendeurServlet
 */
@WebServlet("/Show/Vendeur")
public class AfficherProfilVendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private UserMgr userMgr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherProfilVendeurServlet() {
        super();
        userMgr = new UserMgr();
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
		
		String pseudo = request.getParameter("name");
		
		try {			
			Utilisateur user = userMgr.profilVendeur(pseudo);
			request.setAttribute("user", user);			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ProfilVendeur.jsp");
		rd.forward(request, response);
	}



}
