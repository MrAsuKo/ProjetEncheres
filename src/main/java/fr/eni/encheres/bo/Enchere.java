package fr.eni.encheres.bo;

public class Enchere {

	private int idEnchere;
	private int offre;
	private int noArticle;
	private int id;
	private String pseudo;

	/**
	 * @param offre
	 */
	public Enchere(int idEnchere, int offre) {
		this.idEnchere=idEnchere;
		this.offre = offre;
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

	public Enchere(int idEnchere, int offre, String pseudo) {
		this.idEnchere=idEnchere;
		this.offre = offre;
		this.pseudo = pseudo;
	}

	public Enchere(int offre, int noArticle, int id) {
		this.offre = offre;
		this.noArticle = noArticle;
		this.id = id;
	}

	/**
	 * @param noArticle
	 */
	public Enchere(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @return the offre
	 */
	public int getOffre() {
		return offre;
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
	public void setOffre(int offre) {
		this.offre = offre;
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
