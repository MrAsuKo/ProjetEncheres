package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Articles_vendus;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.VenteDAOjdclImpl;

public class VenteMgr {

	private VenteDAOjdclImpl venteDAO;
	
	public VenteMgr() {
		super();
		venteDAO = new VenteDAOjdclImpl();
	}

	public void ajoutEnchere(String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres, int prixdepart, Utilisateur utilisateur, Categorie categorie) throws Exception {
		// construire lobjet BO
		Articles_vendus vente = new Articles_vendus(nom_article, description, date_debut_encheres, date_fin_encheres, prixdepart,utilisateur,categorie);
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		this.venteDAO.insert(vente);	
	}

	public List<Articles_vendus> selectEnchere() throws SQLException, DALException, fr.eni.encheres.dal.DALException {		
		return this.venteDAO.selectEnchere();
	}

	public void offreEnchere(int offre, int noArticle, int id) {
		try {
			Enchere enchere = new Enchere(offre, noArticle, id);
			venteDAO.offreEnchere(enchere);
		} catch (fr.eni.encheres.dal.DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Enchere meilleurOffre(int noArticle) throws fr.eni.encheres.dal.DALException {
			return this.venteDAO.meilleurOffre(noArticle);
	}

	public List<Articles_vendus> selectencherecateg(int no_categorie) throws fr.eni.encheres.dal.DALException {
		return this.venteDAO.selectEnchereCateg(no_categorie);
	}



	public List<Articles_vendus> selectEnchereContient(String contient) throws fr.eni.encheres.dal.DALException {
		return this.venteDAO.selectEnchereContient(contient);
	}

	public void insertRetrait (int noArticle, String rue, String cp, String ville) throws SQLException, fr.eni.encheres.dal.DALException {
		venteDAO.insertRetrait(noArticle,rue,cp,ville);	
	}	
	
}
