package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.VenteDAOjdclImpl;

public class CategorieMgr {

	private VenteDAOjdclImpl CategoDAO;
	
	public CategorieMgr() {
		super();
		CategoDAO = new VenteDAOjdclImpl();
	}
	
	public List<Categorie> selectcategorie() throws SQLException, DALException {
		return this.CategoDAO.selectCategorie();
	}
}
