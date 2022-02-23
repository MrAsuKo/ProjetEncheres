package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Articles_vendus;

public class VenteDAOjdclImpl {

	private static final String INSERT_ENCHERE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)VALUES(?,?,?,?,?,?,?,?)";

	public void insert(Articles_vendus vente) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1, vente.getNomArticle());
			rqt.setString(2, vente.getDescription());
			rqt.setDate(3, java.sql.Date.valueOf(vente.getDateDebutEncheres()));
			rqt.setDate(4, java.sql.Date.valueOf(vente.getDateFinEncheres()));
			rqt.setInt(5, vente.getPrixDepart());
			rqt.setInt(6, 0);
			rqt.setInt(7, vente.getUtilisateur().getId());
			rqt.setInt(8, vente.getCategorie().getNumcatego());
			rqt.executeUpdate();
			
			ResultSet rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				vente.setNoArticle(rs.getInt(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String SELECTCATEGO = "SELECT no_categorie,libelle FROM CATEGORIES";

	public List<Categorie> selectCategorie() throws DALException {
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement rqt = cnx.createStatement();
			ResultSet rs = rqt.executeQuery(SELECTCATEGO);
			while (rs.next()) {
				int num = (rs.getInt("no_categorie"));
				String libelle = (rs.getString("libelle"));
				Categorie categorie = new Categorie(num, libelle);
				listeCategorie.add(categorie);
			}
		} catch (SQLException e) {
			throw new DALException(" erreur selectCategorie -");
		}

		return listeCategorie;

	}

	private static final String SELECTENCHERE = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle,telephone FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie ORDER BY date_fin_encheres DESC";

	public List<Articles_vendus> selectEnchere() throws DALException {
		List<Articles_vendus> listeEnchere = new ArrayList<Articles_vendus>();
		try (Connection cnx= ConnectionProvider.getConnection()){

			Statement rqt = cnx.createStatement();
			ResultSet rs = rqt.executeQuery(SELECTENCHERE);
			while (rs.next()) {
				int no_article = (rs.getInt("no_article"));
				String nom_article = (rs.getString("nom_article"));
				String description = (rs.getString("description"));
				LocalDate date_debut_encheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate date_fin_encheres = rs.getDate("date_fin_encheres").toLocalDate();
				int prixDepart = (rs.getInt("prix_initial"));
				int prixVente = (rs.getInt("prix_vente"));
				int no_utilisateur = (rs.getInt("no_utilisateur"));
				int no_categorie = (rs.getInt("no_categorie"));
				String telephone = (rs.getString("telephone"));
				String pseudo = rs.getString("pseudo");
				String libellecatego = (rs.getString("libelle"));
				Utilisateur utilisateur = new Utilisateur (no_utilisateur, pseudo, telephone);
				Categorie categorie = new Categorie(no_categorie,libellecatego);
				Articles_vendus vente = new Articles_vendus(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prixDepart,
						prixVente, categorie, utilisateur);
				System.out.println(vente.getNoArticle());
				listeEnchere.add(vente);

			}
		} catch (SQLException e) {
			throw new DALException(" erreur selectCategorie -");
		}
		return listeEnchere;

	}

	private static final String INSERT_OFFRE_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?)";

	public void offreEnchere(Enchere enchere) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){ 
			PreparedStatement rqt = cnx.prepareStatement(INSERT_OFFRE_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			rqt.setInt(2, enchere.getMontantEnchere());
			rqt.setInt(3, enchere.getArticlesVendus().getNoArticle());
			rqt.setInt(4, enchere.getUtilisateur().getId());
			rqt.executeUpdate();
			ResultSet rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
			}

		} catch (SQLException e) {
			throw new DALException(" erreur insert enchere -");
		}
	}

	private static final String SELECT_MEILLEUR_OFFRE = "  SELECT u.no_utilisateur,pseudo,montant_enchere FROM UTILISATEURS u JOIN ENCHERES e ON u.no_utilisateur = e.no_utilisateur WHERE montant_enchere = (SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article=?) AND no_article = ?";

	public Enchere meilleurOffre(int noArticle) throws DALException {
		Enchere enchere = null;
		try (Connection cnx = ConnectionProvider.getConnection()) { 
			PreparedStatement rqt = cnx.prepareStatement(SELECT_MEILLEUR_OFFRE);
			rqt.setInt(1, noArticle);
			rqt.setInt(2, noArticle);
			ResultSet rs = rqt.executeQuery();
			if (rs.next()) {
				int noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				int montantEnchere = rs.getInt("montant_enchere");
				System.out.println("test " + montantEnchere);
				Utilisateur utilisateur = new Utilisateur (noUtilisateur,pseudo);
				enchere = new Enchere(utilisateur, montantEnchere);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(" erreur meilleur offre -");
		}
		return enchere;		
	}

	private static final String SELECTENCHERECATEG = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie WHERE c.no_categorie=?";

	public List<Articles_vendus> selectEnchereCateg(int no_categ) throws DALException {
		List<Articles_vendus> listeEnchere = new ArrayList<Articles_vendus>();
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement rqt = cnx.prepareStatement(SELECTENCHERECATEG);
			rqt.setInt(1, no_categ);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				int no_article = (rs.getInt("no_article"));
				String nom_article = (rs.getString("nom_article"));
				String description = (rs.getString("description"));
				LocalDate date_debut_encheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate date_fin_encheres = rs.getDate("date_fin_encheres").toLocalDate();
				int prixDepart = (rs.getInt("prix_initial"));
				int prixVente = (rs.getInt("prix_vente"));
				int no_utilisateur = (rs.getInt("no_utilisateur"));
				int no_categorie = (rs.getInt("no_categorie"));
				String telephone = (rs.getString("telephone"));
				String prixDepartStr = String.valueOf(prixDepart);
				String pseudo = rs.getString("pseudo");
				String libellecatego = (rs.getString("libelle"));
				Utilisateur utilisateur = new Utilisateur (no_utilisateur, pseudo, telephone);
				Categorie categorie = new Categorie(no_categorie,libellecatego);
				Articles_vendus vente = new Articles_vendus(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prixDepart,
						prixVente, categorie, utilisateur);
				listeEnchere.add(vente);

			}
		} catch (SQLException e) {
			throw new DALException(" select catego -");
		}
		return listeEnchere;
	}

	private static final String SELECTENCHERECONTIENT = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie WHERE nom_article LIKE ?";

	public List<Articles_vendus> selectEnchereContient(String contient) throws DALException {
		List<Articles_vendus> listeEnchere = new ArrayList<Articles_vendus>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = cnx.prepareStatement(SELECTENCHERECONTIENT);
			rqt.setString(1, '%' + contient + '%');
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				int no_article = (rs.getInt("no_article"));
				String nom_article = (rs.getString("nom_article"));
				String description = (rs.getString("description"));
				LocalDate date_debut_encheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate date_fin_encheres = rs.getDate("date_fin_encheres").toLocalDate();
				int prixDepart = (rs.getInt("prix_initial"));
				int prixVente = (rs.getInt("prix_vente"));
				int no_utilisateur = (rs.getInt("no_utilisateur"));
				int no_categorie = (rs.getInt("no_categorie"));
				String telephone = (rs.getString("telephone"));
				String prixDepartStr = String.valueOf(prixDepart);
				String pseudo = rs.getString("pseudo");
				String libellecatego = (rs.getString("libelle"));
				Utilisateur utilisateur = new Utilisateur (no_utilisateur, pseudo, telephone);
				Categorie categorie = new Categorie(no_categorie,libellecatego);
				Articles_vendus vente = new Articles_vendus(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prixDepart,
						prixVente, categorie, utilisateur);
				listeEnchere.add(vente);

			}
		} catch (SQLException e) {
			throw new DALException(" select catego -");
		}
		return listeEnchere;
	}

	private static final String INSERTRETRAIT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) VALUES (?,?,?,?)";

	public void insertRetrait(int noArticle, String rue, String cp, String ville) throws SQLException, DALException {
			try (Connection cnx = ConnectionProvider.getConnection()){ 
			
			PreparedStatement rqt = cnx.prepareStatement(INSERTRETRAIT);
			rqt.setInt(1, noArticle);
			rqt.setString(2, rue);
			rqt.setString(3, cp);
			rqt.setString(4, ville);
			rqt.executeUpdate();
		
	}
}
	
}
