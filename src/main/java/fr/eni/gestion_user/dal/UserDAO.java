package fr.eni.gestion_user.dal;

import java.sql.SQLException;

import fr.eni.gestion_user.bo.User;

public interface UserDAO {

	public void insert(User user) throws DALException, SQLException;	
	public boolean select(User user) throws DALException;	
	public void delete(User user) throws DALException;
	
}
