package fr.eni.gestion_vente.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.gestion_user.dal.ConnectionProvider;
import fr.eni.gestion_user.dal.DALException;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.bo.Vente;

public class VenteDAOjdclImpl {

	private static final String INSERT_ENCHERE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)VALUES(?,?,?,?,?,?,?,?)";
	
	public void insert(Vente vente) throws DALException {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false);
			PreparedStatement rqt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1, vente.getArticle());
			rqt.setString(2, vente.getDescription());
			rqt.setString(3, vente.getDebutenchere());
			rqt.setString(4, vente.getFinenchere());
			rqt.setString(5, vente.getPrixdepart());
			rqt.setInt(6, 0);
			rqt.setInt(7, 1);
			rqt.setInt(8, 1);
			rqt.executeUpdate();
			ResultSet rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				vente.setId(rs.getInt(1));
			}
			cnx.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String SELECTCATEGO ="SELECT no_categorie,libelle FROM CATEGORIES";
	public List<Categorie> selectcategorie() throws SQLException, DALException {
		Connection cnx = null;
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
			cnx = ConnectionProvider.getConnection();		
			PreparedStatement rqt = cnx.prepareStatement(SELECTCATEGO);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				int num = (rs.getInt("no_categorie"));
				String libelle = (rs.getString("libelle"));
				Categorie categorie = new Categorie (num,libelle);
				listeCategorie.add(categorie);
			}
			System.out.println("DAL : " + listeCategorie);
			return listeCategorie;
		
	}
}
