package fr.eni.gestion_user.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.gestion_user.bo.User;

public class userDAOjdcImpl implements UserDAO {

	private static final String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_USERPSEUDO = "SELECT pseudo FROM UTILISATEURS WHERE pseudo=?";
	private static final String SELECT_USEREMAIL = "SELECT email FROM UTILISATEURS WHERE email=?";
	private static final String SELECT_USER = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo=? and mot_de_passe=?";
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE pseudo=?";
	private static final String UPDATE_USER ="UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=? WHERE pseudo=? and mot_de_passe=?";
	
	public boolean verif(User user) throws DALException {
		Connection cnx = null;
		boolean use = false;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement rqt2 = cnx.prepareStatement(SELECT_USERPSEUDO);
			rqt2.setString(1,user.getPseudo());
			ResultSet rs2 = rqt2.executeQuery();
			if (rs2.next()) {
				use = true;
			}
			PreparedStatement rqt3 = cnx.prepareStatement(SELECT_USEREMAIL);
			rqt3.setString(1,user.getEmail());
			ResultSet rs3 = rqt3.executeQuery();
			if (rs3.next()) {
				use = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return use;
	}
	
	public void insert(User user) throws DALException {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1, user.getPseudo());
			rqt.setString(2, user.getNom());
			rqt.setString(3, user.getPrenom());
			rqt.setString(4, user.getEmail());
			rqt.setString(5, user.getTelephone());
			rqt.setString(6, user.getRue());
			rqt.setString(7, user.getCp());
			rqt.setString(8, user.getVille());
			rqt.setString(9, user.getMdp());
			rqt.setInt(10, 100);
			rqt.setBoolean(11, false);
			rqt.executeUpdate();
			ResultSet rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User select(User user) throws DALException {
		Connection cnx = null;
		boolean trouve = false;
		try {
			cnx = ConnectionProvider.getConnection();		
			PreparedStatement rqt = cnx.prepareStatement(SELECT_USER);
			rqt.setString(1,user.getPseudo());
			rqt.setString(2,user.getMdp());
			ResultSet rs = rqt.executeQuery();
			if (rs.next()) {
				trouve = true;
				user.setId(rs.getInt("no_utilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setRue(rs.getString("rue"));
				user.setCp(rs.getString("code_postal"));
				user.setVille(rs.getString("ville"));
				user.setMdp(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdministrateur(rs.getBoolean("administrateur"));
				user.setTrouve(trouve);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void delete(User user) throws DALException   {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(DELETE_USER);
			rqt.setString(1,user.getPseudo());
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public void modif(User user) throws DALException {
		 Connection cnx = null;
		 try {
			 cnx = ConnectionProvider.getConnection();
			 PreparedStatement rqt = cnx.prepareStatement(UPDATE_USER);
			 rqt.setString(9,user.getPseudo());
			 rqt.setString(10,user.getMdp());
			 ResultSet rs = rqt.executeQuery();
			 System.out.println(user.getPseudo());
			 if (rs.next()) {
				rqt.setString(1, user.getPseudo());
				rqt.setString(2, user.getNom());
				rqt.setString(3, user.getPrenom());
				rqt.setString(4, user.getEmail());
				rqt.setString(5, user.getTelephone());
				rqt.setString(6, user.getRue());
				rqt.setString(7, user.getCp());
				rqt.setString(8, user.getVille());
				rqt.executeUpdate();
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}
