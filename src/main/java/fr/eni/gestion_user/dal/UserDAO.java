package fr.eni.gestion_user.dal;

import java.sql.SQLException;

import fr.eni.gestion_user.bo.User;

public interface UserDAO {
	
	public boolean verif(User user) throws DALException;
	public void insert(User user) throws DALException;	
	public User select(User user) throws DALException;	
	public void delete(User user) throws DALException;
	public void modif(User user) throws DALException;
	public User profilVendeur(String pseudo) throws DALException;
	
}
