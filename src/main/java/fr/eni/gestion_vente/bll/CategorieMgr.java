package fr.eni.gestion_vente.bll;

import java.sql.SQLException;
import java.util.List;


import fr.eni.gestion_user.dal.DALException;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.dal.VenteDAOjdclImpl;

public class CategorieMgr {

	private VenteDAOjdclImpl CategoDAO;
	
	public CategorieMgr() {
		super();
		CategoDAO = new VenteDAOjdclImpl();
	}
	
	public List<Categorie> selectcategorie() throws SQLException, DALException {
		return this.CategoDAO.selectcategorie();
	}
}
