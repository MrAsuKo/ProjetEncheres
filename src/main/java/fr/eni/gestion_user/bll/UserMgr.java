package fr.eni.gestion_user.bll;

import fr.eni.gestion_user.bo.User;
import fr.eni.gestion_user.dal.UserDAO;
import fr.eni.gestion_user.dal.userDAOjdcImpl;

public class UserMgr {

	private UserDAO userDAO;
	
	public UserMgr() {
		super();
		userDAO = new userDAOjdcImpl();
	}
	
	public boolean verifierUser(String pseudo, String email, String mdp) throws Exception {
		// construire lobjet BO
		User user = new User(pseudo, email, mdp);
	
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		boolean use = userDAO.verif(user);
		return use;
	}
	
	public User ajouterUser(String pseudo, String nom, String prenom, String email, String telepone, String rue, String cp, String ville, String mdp) throws Exception {
		// construire lobjet BO
		User user = new User(pseudo, nom, prenom, email, telepone, rue, cp, ville, mdp);
	
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		userDAO.insert(user);
		return user;
	}

	public boolean selectUser(String pseudo, String mdp) throws Exception {
		User user = new User(pseudo, mdp);
		boolean trouve = userDAO.select(user);
		return trouve;
	}
	
	public void supprimerUser(String pseudo) throws Exception {
		User user = new User(pseudo);
		userDAO.delete(user);
	}
}