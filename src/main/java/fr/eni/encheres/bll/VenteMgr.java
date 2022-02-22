package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Vente;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.VenteDAOjdclImpl;

public class VenteMgr {

	private VenteDAOjdclImpl venteDAO;
	
	public VenteMgr() {
		super();
		venteDAO = new VenteDAOjdclImpl();
	}



	public int ajoutenchere(String article, String description, String debutenchere, String finenchere, String prixdepart, int id, int numcategorie) throws Exception {
		// construire lobjet BO
		Vente vente = new Vente(article, description, debutenchere, finenchere, prixdepart, id, numcategorie);
	
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		return  this.venteDAO.insert(vente);

		
	}

	public List<Vente> selectenchere() throws SQLException, DALException, fr.eni.encheres.dal.DALException {		
		return this.venteDAO.selectenchere();
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
		Enchere enchere = new Enchere(noArticle);
			return this.venteDAO.meilleurOffre(enchere);

	}



	public List<Vente> selectencherecateg(int categ) throws fr.eni.encheres.dal.DALException {
		Vente vente = new Vente (categ);
		return this.venteDAO.selectencherecateg(vente);
	}



	public List<Vente> selectencherecontient(String contient) throws fr.eni.encheres.dal.DALException {
		Vente vente = new Vente (contient);
		return this.venteDAO.selectencherecontient(vente);
	}



	public void insertretrait (int noArticle, String rue, String cp, String ville) throws SQLException, fr.eni.encheres.dal.DALException {
		venteDAO.insertretrait(noArticle,rue,cp,ville);
		
		
		
	}	
	

}
