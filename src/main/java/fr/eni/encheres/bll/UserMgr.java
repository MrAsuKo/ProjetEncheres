package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
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
		Utilisateur user = new Utilisateur(pseudo, email, mdp);
	
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		boolean use = userDAO.verif(user);
		return use;
	}
	
	public Utilisateur ajouterUser(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp, String ville, String mdp) throws BLLException {

		BLLException be = new BLLException("ajouterUser");
		
		verifEmail(email, be);
		verifTelephone(telephone, be);
		
		if(be.hasErreur()) {
			throw be;
		}		
		
		// construire lobjet BO
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp);

		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		try {
			userDAO.insert(user);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		
		return user;
		
	}
	
	private void verifEmail(String email, BLLException e) {
		if(email == null || email.isBlank() || !email.contains("@")) {
			e.ajouterErreur("Adresse email obligatoire et format : toto@gmail.com");
		}
	}
	
	private void verifTelephone(String telephone, BLLException e) {
		if(telephone == null || telephone.isBlank() || telephone.length() != 10) {
			e.ajouterErreur("Le téléphone est obligatoire et format : 0123456789");
		}
	}
	
	

	public Utilisateur selectUser(String pseudo, String mdp) throws Exception {
		Utilisateur user = new Utilisateur(pseudo, mdp);
		userDAO.select(user);
		return user;
	}
	
	public void supprimerUser(String pseudo) throws Exception {
		Utilisateur user = new Utilisateur(pseudo);
		userDAO.delete(user);
	}
	
	public void modifUser(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp, String ville, String mdp) throws Exception {
		System.out.println("modifUser");
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp);
		userDAO.modif(user);
	}

	public Utilisateur profilVendeur(String pseudo) throws DALException {
		return userDAO.profilVendeur(pseudo);
	}


		
	}
