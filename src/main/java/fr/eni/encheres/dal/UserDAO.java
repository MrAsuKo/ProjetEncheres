package fr.eni.encheres.dal;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public interface UserDAO {
	
	public boolean verif(Utilisateur user) throws DALException;
	public void insert(Utilisateur user) throws DALException;	
	public Utilisateur select(Utilisateur user) throws DALException;	
	public void delete(Utilisateur user) throws DALException;
	public void modif(Utilisateur user) throws DALException;
	public Utilisateur profilVendeur(String pseudo) throws DALException;
	
}
