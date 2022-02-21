package fr.eni.gestion_vente.bo;

import java.time.LocalDate;

public class Vente {

	private String article;
	private String description;
	private String debutenchere;
	private String finenchere;
	private String prixdepart;
	private int iduser;
	private int idEnchere;
	private int numcategorie;
	private int prixvente;
	private String pseudo;
	private String libellecatego;
	private String contient;
	
	/**
	 * @return the libellecatego
	 */
	public String getLibellecatego() {
		return libellecatego;
	}
	/**
	 * @param libellecatego the libellecatego to set
	 */
	public void setLibellecatego(String libellecatego) {
		this.libellecatego = libellecatego;
	}
	/**
	 * @return the iduser
	 */
	public int getIduser() {
		return iduser;
	}
	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	/**
	 * @return the idEnchere
	 */
	public int getIdEnchere() {
		return idEnchere;
	}
	/**
	 * @param idEnchere the idEnchere to set
	 */
	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}
	/**
	 * @return the numcategorie
	 */
	public int getNumcategorie() {
		return numcategorie;
	}
	/**
	 * @param numcategorie the numcategorie to set
	 */
	public void setNumcategorie(int numcategorie) {
		this.numcategorie = numcategorie;
	}
	/**
	 * @return the prixvente
	 */
	public int getPrixvente() {
		return prixvente;
	}
	/**
	 * @param prixvente the prixvente to set
	 */
	public void setPrixvente(int prixvente) {
		this.prixvente = prixvente;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @param article
	 * @param description
	 * @param debutenchere
	 * @param finenchere
	 * @param prixdepart
	 * @param numcategorie 
	 * @param numcategorie2 
	 */
	public Vente(String article, String description, String debutenchere, String finenchere, String prixdepart, int iduser, int numcategorie) {
		this.article = article;
		this.description = description;
		this.debutenchere = debutenchere;
		this.finenchere = finenchere;
		this.prixdepart = prixdepart;
		this.numcategorie = numcategorie;
		this.iduser = iduser;
	}
	public Vente(int idEnchere, String article, String description, String debutenchere, String finenchere, String prixdepart,int prixvente, int iduser, int numcategorie, String pseudo, String libellecatego) {
		this.idEnchere = idEnchere;
		this.article = article;
		this.description = description;
		this.debutenchere = debutenchere;
		this.finenchere = finenchere;
		this.prixdepart = prixdepart;
		this.prixvente = prixvente;
		this.numcategorie = numcategorie;
		this.iduser=iduser;
		this.pseudo=pseudo;
		this.libellecatego = libellecatego;
	}
		
	public Vente(int numcategorie) {
		this.numcategorie = numcategorie;
	}
	public Vente(String contient) {
		this.contient=contient;
	}
	/**
	 * @return the categorie
	 */
	public int getCategorie() {
		return numcategorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(int categorie) {
		this.numcategorie = categorie;
	}
	/**
	 * @return the article
	 */
	public String getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(String article) {
		this.article = article;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the contient
	 */
	public String getContient() {
		return contient;
	}
	/**
	 * @param contient the contient to set
	 */
	public void setContient(String contient) {
		this.contient = contient;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the debutenchere
	 */
	public String getDebutenchere() {
		return debutenchere;
	}
	/**
	 * @param debutenchere the debutenchere to set
	 */
	public void setDebutenchere(String debutenchere) {
		this.debutenchere = debutenchere;
	}
	/**
	 * @return the finenchere
	 */
	public String getFinenchere() {
		return finenchere;
	}
	/**
	 * @param finenchere the finenchere to set
	 */
	public void setFinenchere(String finenchere) {
		this.finenchere = finenchere;
	}
	/**
	 * @return the prixdepart
	 */
	public String getPrixdepart() {
		return prixdepart;
	}
	/**
	 * @param prixdepart the prixdepart to set
	 */
	public void setPrixdepart(String prixdepart) {
		this.prixdepart = prixdepart;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return iduser;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.iduser = id;
	}
	@Override
	public String toString() {
		return String.format("Vente [article=%s, description=%s, debutenchere=%s, finenchere=%s, prixdepart=%s, id=%s]",
				article, description, debutenchere, finenchere, prixdepart, iduser);
	}

	
	


}
