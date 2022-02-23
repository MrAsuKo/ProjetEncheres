package fr.eni.encheres.bo;

import java.sql.Date;

public class Enchere {

	private int noEnchere;
	private Date dateEnchere;
	private int montantEnchere;
	private Articles_vendus articlesVendus;
	private Utilisateur utilisateur;
	
	/**
	 * @param noEnchere
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param articlesVendus
	 * @param utilisateur
	 */
	public Enchere(int noEnchere, Date dateEnchere, int montantEnchere, Articles_vendus articlesVendus,
			Utilisateur utilisateur) {
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articlesVendus = articlesVendus;
		this.utilisateur = utilisateur;
	}

	public Enchere(Utilisateur utilisateur, int montantEnchere) {
		this.utilisateur=utilisateur;
		this.montantEnchere=montantEnchere;
	}

	public Enchere(int offre, Articles_vendus articlesVendus, Utilisateur utilisateur) {
		this.montantEnchere=offre;
		this.articlesVendus=articlesVendus;
		this.utilisateur=utilisateur;
	}

	/**
	 * @return the noEnchere
	 */
	public int getNoEnchere() {
		return noEnchere;
	}

	/**
	 * @param noEnchere the noEnchere to set
	 */
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	/**
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the articlesVendus
	 */
	public Articles_vendus getArticlesVendus() {
		return articlesVendus;
	}

	/**
	 * @param articlesVendus the articlesVendus to set
	 */
	public void setArticlesVendus(Articles_vendus articlesVendus) {
		this.articlesVendus = articlesVendus;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	
}
