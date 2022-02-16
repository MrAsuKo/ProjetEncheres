package fr.eni.gestion_user.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.gestion_user.dal.ConnectionProvider;
import fr.eni.gestion_user.bo.User;

public class userDAOjdcImpl {

	private static final String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_USER ="SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo=? and mot_de_passe=?";
	
	public void insert(User user) throws Exception {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false);
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
			cnx.commit();
		} catch (SQLException e) {
			cnx.rollback();
			e.printStackTrace();
		}
	}

	public boolean select(User user) throws Exception {
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trouve;
	}
	
	public boolean delete(User user) throws Exception {
		
	}
}

