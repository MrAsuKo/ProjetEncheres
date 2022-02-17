package fr.eni.gestion_vente.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.gestion_user.dal.ConnectionProvider;
import fr.eni.gestion_user.dal.DALException;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.bo.Enchere;
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
			rqt.setInt(7, vente.getId());
			rqt.setInt(8, vente.getCategorie());
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
	public List<Categorie> selectcategorie(){
		Connection cnx = null;
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		try{	
		cnx = ConnectionProvider.getConnection();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
			Statement rqt;
			try {
			rqt = cnx.createStatement();
			ResultSet rs = rqt.executeQuery(SELECTCATEGO);
			while (rs.next()) {
				int num = (rs.getInt("no_categorie"));
				String libelle = (rs.getString("libelle"));
				Categorie categorie = new Categorie (num,libelle);
				listeCategorie.add(categorie);
			}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return listeCategorie;
		
	}
	
	private static final String SELECTENCHERE ="SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie";
	public List<Vente> selectenchere(){
		Connection cnx = null;
		List<Vente> listeEnchere = new ArrayList<Vente>();
		try{	
		cnx = ConnectionProvider.getConnection();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
			Statement rqt;
			try {
			rqt = cnx.createStatement();
			ResultSet rs = rqt.executeQuery(SELECTENCHERE);
			while (rs.next()) {
				int idEnchere = (rs.getInt("no_article"));
				String article = (rs.getString("nom_article"));
				String description = (rs.getString("description"));
				LocalDate debutEnchereDate = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate finEnchereDate = rs.getDate("date_fin_encheres").toLocalDate();
				int prixDepart = (rs.getInt("prix_initial"));
				int prixVente = (rs.getInt("prix_vente"));
				int numUser = (rs.getInt("no_utilisateur"));
				int numCatego = (rs.getInt("no_categorie"));
				String prixDepartStr = String.valueOf(prixDepart);
				String debutEnchere = debutEnchereDate.toString();
				String finEnchere = finEnchereDate.toString();
				String pseudo = rs.getString("pseudo");
				String libellecatego = (rs.getString("libelle"));
				Vente vente = new Vente (idEnchere,article,description,debutEnchere,finEnchere,prixDepartStr,prixVente,numUser,numCatego,pseudo,libellecatego);
				listeEnchere.add(vente);
				
			}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(listeEnchere.get(1));
			return listeEnchere;
		
	}
	
	private static final String INSERTOFFREENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?)";
	public void offreEnchere(Enchere enchere) throws DALException {
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(INSERTOFFREENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			rqt.setInt(2, enchere.getOffre());
			rqt.setInt(3, enchere.getNoArticle());
			rqt.setInt(4, enchere.getId());
			rqt.executeUpdate();
			ResultSet rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setIdEnchere(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
