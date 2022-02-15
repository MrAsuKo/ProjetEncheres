package fr.eni.gestion_vente.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreationUser
 */
@WebServlet("/CreationUser")
public class CreationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUser() {
        super();
        // TODO Auto-generated constructor stub
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
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		String mdpconf = request.getParameter("mdp_conf");
		
		if (mdpconf.equals(mdp)) {
			String message = "utilisateur créer";
			request.setAttribute("message", message);
			System.out.println(message);
			RequestDispatcher rd = request.getRequestDispatcher("/AccueilConnecter.jsp");
			rd.forward(request, response);
		}
		else {
		String message = "les mdp ne corespondent pas";
		request.setAttribute("message", message);
		System.out.println(message);
		RequestDispatcher rd = request.getRequestDispatcher("/Inscription.jsp");
		rd.forward(request, response);
		}


		
	}

}
