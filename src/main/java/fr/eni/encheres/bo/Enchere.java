package fr.eni.encheres.bo;

import java.sql.Date;

public class Enchere {

	private int noEnchere;
	private Date dateEnchere;
	private int montantEnchere;
	private int noArticle;
	private int noUtilisateur;
	private String pseudo;

	/**
	 * @param offre
	 */
	public Enchere(int idEnchere, int montantEnchere) {
		this.noEnchere=idEnchere;
		this.montantEnchere = montantEnchere;
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

	public Enchere(int idEnchere, int montantEnchere, String pseudo) {
		this.noEnchere=idEnchere;
		this.montantEnchere = montantEnchere;
		this.pseudo = pseudo;
	}

	public Enchere(int montantEnchere, int noArticle, int id) {
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = id;
	}

	/**
	 * @param noArticle
	 */
	public Enchere(int noArticle) {
		this.noArticle = noArticle;
	}

	public Enchere(int id, String pseudo, int montantEnchere) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return noUtilisateur;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.noUtilisateur = id;
	}

	/**
	 * @param offre the offre to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the idEnchere
	 */
	public int getIdEnchere() {
		return noEnchere;
	}

	/**
	 * @param idEnchere the idEnchere to set
	 */
	public void setIdEnchere(int idEnchere) {
		this.noEnchere = idEnchere;
	}

	@Override
	public String toString() {
		return String.format("Enchere [idEnchere=%s, montantEnchere=%s, noArticle=%s, id=%s, pseudo=%s]", noEnchere,
				montantEnchere, noArticle, noUtilisateur, pseudo);
	}
	
}
