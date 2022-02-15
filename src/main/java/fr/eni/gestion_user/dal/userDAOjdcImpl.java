package fr.eni.gestion_user.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.gestion_user.dal.ConnectionProvider;
import fr.eni.gestion_user.bo.User;

public class userDAOjdcImpl {

	private static final String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
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
			rqt.setInt(10, 0);
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

	public void verif(User user) throws Exception {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();		
			Statement rqt = cnx.createStatement();
			ResultSet rs = rqt.executeQuery("SELECT pseudo, mot_de_passe FROM UTILISATEURS WHERE pseudo='" + user.getPseudo() + "';");
			String mot_de_passe = null;
			while (rs.next()) {
				String pseudo = rs.getString("pseudo");
				String mdp = rs.getString("mot_de_passe");
				mot_de_passe = mdp;
				System.out.println(pseudo + mdp);
			}
			boolean mdpEtat = false;
			if (user.getMdp().equals(mot_de_passe) ) {
				mdpEtat = true;
			} else {
				String message = "Mot de passe incorrect";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}