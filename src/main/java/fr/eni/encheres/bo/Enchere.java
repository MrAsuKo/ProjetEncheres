package fr.eni.encheres.bo;

public class Enchere {

	private int idEnchere;
	private int montantEnchere;
	private int noArticle;
	private int id;
	private String pseudo;

	/**
	 * @param offre
	 */
	public Enchere(int idEnchere, int montantEnchere) {
		this.idEnchere=idEnchere;
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
		this.idEnchere=idEnchere;
		this.montantEnchere = montantEnchere;
		this.pseudo = pseudo;
	}

	public Enchere(int montantEnchere, int noArticle, int id) {
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.id = id;
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
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
		return idEnchere;
	}

	/**
	 * @param idEnchere the idEnchere to set
	 */
	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}
	
}
