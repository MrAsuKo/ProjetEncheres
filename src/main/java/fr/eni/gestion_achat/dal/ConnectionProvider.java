package fr.eni.gestion_achat.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	public static Connection getConnection() throws DALException {
		Connection cnx = null;
		try {
			Context context = new InitialContext();
			DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/GestionLiseCourse");
			cnx = datasource.getConnection();
		} catch (NamingException e) {
			DALException exception = new DALException("la ressource pool de connexion est introuvable");
			throw exception;
		} catch (SQLException e) {
			DALException exception = new DALException("Probleme à la connexion "+ e.getMessage());
			throw exception;
		}
		return cnx;
	}
	
}
