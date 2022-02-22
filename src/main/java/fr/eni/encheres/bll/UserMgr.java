package fr.eni.encheres.bll;

import fr.eni.encheres.bo.User;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.UserDAO;
import fr.eni.encheres.dal.UserDAOjdcImpl;

public class UserMgr {

	private UserDAO userDAO;
	
	public UserMgr() {
		super();
		userDAO = new UserDAOjdcImpl();
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

	public User selectUser(String pseudo, String mdp) throws Exception {
		User user = new User(pseudo, mdp);
		userDAO.select(user);
		return user;
	}
	
	public void supprimerUser(String pseudo) throws Exception {
		User user = new User(pseudo);
		userDAO.delete(user);
	}
	
	public void modifUser(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp, String ville, String mdp) throws Exception {
		User user = new User(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp);
		userDAO.modif(user);
	}

	public User profilVendeur(String pseudo) throws DALException {
		return userDAO.profilVendeur(pseudo);
	}
}