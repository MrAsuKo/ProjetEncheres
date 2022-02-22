package fr.eni.gestion_vente.dal;

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

import fr.eni.gestion_user.dal.ConnectionProvider;
import fr.eni.gestion_user.dal.DALException;
import fr.eni.gestion_vente.bo.Categorie;
import fr.eni.gestion_vente.bo.Enchere;
import fr.eni.gestion_vente.bo.Vente;

public class VenteDAOjdclImpl {

	private static final String INSERT_ENCHERE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)VALUES(?,?,?,?,?,?,?,?)";

	public void insert(Vente vente) throws DALException {

		try(Connection cnx = ConnectionProvider.getConnection()) {
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

	private static final String SELECTCATEGO = "SELECT no_categorie,libelle FROM CATEGORIES";

	public List<Categorie> selectcategorie() throws DALException {
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
			// TODO Auto-generated catch block
			throw new DALException(" erreur selectCategorie -");
		}

		return listeCategorie;

	}

	private static final String SELECTENCHERE = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie";

	public List<Vente> selectenchere() throws DALException {
		List<Vente> listeEnchere = new ArrayList<Vente>();
		try (Connection cnx= ConnectionProvider.getConnection()){

			Statement rqt = cnx.createStatement();
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
				Vente vente = new Vente(idEnchere, article, description, debutEnchere, finEnchere, prixDepartStr,
						prixVente, numUser, numCatego, pseudo, libellecatego);
				listeEnchere.add(vente);

			}
		} catch (SQLException e) {
			throw new DALException(" erreur selectCategorie -");
		}
		return listeEnchere;

	}

	private static final String INSERTOFFREENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?)";

	public void offreEnchere(Enchere enchere) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){ 
			
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
			throw new DALException(" erreur insert enchere -");
		}
	}

	private static final String SELECT_MEILLEUR_OFFRE = "  SELECT u.no_utilisateur,pseudo,montant_enchere FROM UTILISATEURS u JOIN ENCHERES e ON u.no_utilisateur = e.no_utilisateur WHERE montant_enchere = (SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article=?) AND no_article = ?";

	public Enchere meilleurOffre(Enchere enchere) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) { 
			PreparedStatement rqt = cnx.prepareStatement(SELECT_MEILLEUR_OFFRE);
			rqt.setInt(1, enchere.getNoArticle());
			rqt.setInt(2, enchere.getNoArticle());
			ResultSet rs = rqt.executeQuery();
			if (rs.next()) {
				enchere.setId(rs.getInt("no_utilisateur"));
				enchere.setPseudo(rs.getString("pseudo"));
				enchere.setOffre(rs.getInt("montant_enchere"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(" erreur meilleur offre -");
		}
		return enchere;
	}

	private static final String SELECTENCHERECATEG = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie WHERE c.no_categorie=?";

	public List<Vente> selectencherecateg(Vente vente) throws DALException {
		List<Vente> listeEnchere = new ArrayList<Vente>();
		try (Connection cnx = ConnectionProvider.getConnection();) {

			PreparedStatement rqt = cnx.prepareStatement(SELECTENCHERECATEG);
			rqt.setInt(1, vente.getNumcategorie());
			ResultSet rs = rqt.executeQuery();
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
				Vente vente1 = new Vente(idEnchere, article, description, debutEnchere, finEnchere, prixDepartStr,
						prixVente, numUser, numCatego, pseudo, libellecatego);
				listeEnchere.add(vente1);

			}
		} catch (SQLException e) {
			throw new DALException(" select catego -");
		}
		return listeEnchere;
	}

	private static final String SELECTENCHERECONTIENT = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,av.no_categorie, pseudo, libelle FROM ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u ON u.no_utilisateur = av.no_utilisateur INNER JOIN CATEGORIES as c ON c.no_categorie=av.no_categorie WHERE nom_article LIKE ?";

	public List<Vente> selectencherecontient(Vente vente) throws DALException {
		List<Vente> listeEnchere = new ArrayList<Vente>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = cnx.prepareStatement(SELECTENCHERECONTIENT);
			rqt.setString(1, '%' + vente.getContient() + '%');
			ResultSet rs = rqt.executeQuery();
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
				Vente vente1 = new Vente(idEnchere, article, description, debutEnchere, finEnchere, prixDepartStr,
						prixVente, numUser, numCatego, pseudo, libellecatego);
				listeEnchere.add(vente1);

			}
		} catch (SQLException e) {
			throw new DALException(" select catego -");
		}
		return listeEnchere;
	}

}
