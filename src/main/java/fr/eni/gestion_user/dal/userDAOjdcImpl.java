package fr.eni.gestion_user.dal;

import java.sql.Connection;

import fr.eni.gestion_user.dal.ConnectionProvider;
import fr.eni.gestion_user.bo.User;

public class userDAOjdcImpl {

	private static final String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email,telephone,rue,code_postal,ville, mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?)";
	
	public void insert(User user) {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
