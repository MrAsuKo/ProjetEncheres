package fr.eni.gestion_vente.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.gestion_vente.bo.Vente;
import fr.eni.gestion_vente.dal.DALException;
import fr.eni.gestion_vente.dal.VenteDAOjdclImpl;

public class VenteMgr {

	private VenteDAOjdclImpl venteDAO;
	
	public VenteMgr() {
		super();
		venteDAO = new VenteDAOjdclImpl();
	}



	public void ajoutenchere(String article, String description, String debutenchere, String finenchere, String prixdepart, int id, int numcategorie) throws Exception {
		// construire lobjet BO
		Vente vente = new Vente(article, description, debutenchere, finenchere, prixdepart, id, numcategorie);
	
		//Deleguer à la DAL l'ajout de l'utilisateur à la BDD
		venteDAO.insert(vente);

		
	}

	public List<Vente> selectenchere() throws SQLException, DALException {		
		return this.venteDAO.selectenchere();
	}	
	

}
