package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Articles_vendus {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixDepart;
	private int prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	/**
	 * @param no_article
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param prixdepart
	 * @param prixvente
	 * @param no_utilisateur
	 * @param no_categorie
	 */
	public Articles_vendus(int noArticle, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prixDepart, int prixvente, Utilisateur no_utilisateur, Categorie no_categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nom_article;
		this.description = description;
		this.dateDebutEncheres = date_debut_encheres;
		this.dateFinEncheres = date_fin_encheres;
		this.prixDepart = prixDepart;
		this.prixVente = prixvente;
		this.utilisateur = no_utilisateur;
		this.categorie = no_categorie;
	}
	
	public Articles_vendus(String nomArticle, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prixdepart, Utilisateur no_utilisateur, Categorie no_categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = date_debut_encheres;
		this.dateFinEncheres = date_fin_encheres;
		this.prixDepart = prixdepart;
		this.utilisateur = no_utilisateur;
		this.categorie = no_categorie;
	}

	public Articles_vendus(int noArticle, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prixDepart, int prixVente, Categorie categorie,
			Utilisateur utilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nom_article;
		this.description = description;
		this.dateDebutEncheres = date_debut_encheres;
		this.dateFinEncheres = date_fin_encheres;
		this.prixDepart = prixDepart;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
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
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateDebutEncheres
	 */
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	/**
	 * @return the dateFinEncheres
	 */
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	/**
	 * @return the prixDepart
	 */
	public int getPrixDepart() {
		return prixDepart;
	}

	/**
	 * @param prixDepart the prixDepart to set
	 */
	public void setPrixDepart(int prixDepart) {
		this.prixDepart = prixDepart;
	}

	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
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

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}





}
	
	


		

	
	



