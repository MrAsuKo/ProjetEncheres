package fr.eni.gestion_user.bll;

import fr.eni.gestion_user.bo.User;
import fr.eni.gestion_user.dal.userDAOjdcImpl;

public class UserMgr {

	private userDAOjdcImpl userDAO;
	
	public UserMgr() {
		super();
		userDAO = new userDAOjdcImpl();
	}
	
	public void ajouterUser(String pseudo, String nom, String prenom, String email, String telepone, String rue, String cp, String ville, String mdp) throws Exception {
		// construire lobjet BO
		User user = new User(pseudo, nom, prenom, email, telepone, rue, cp, ville, mdp);
	
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		userDAO.insert(user);
	}

	public void verifierUser(String pseudo, String mdp) throws Exception {
		User user = new User(pseudo, mdp);
		userDAO.verif(user);
	}
}