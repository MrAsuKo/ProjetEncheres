package fr.eni.gestion_vente.bo;

public class Vente {

	private String article;
	private String description;
	private String debutenchere;
	private String finenchere;
	private String prixdepart;
	private int id;
	private Categorie categorie;
	
	/**
	 * @param article
	 * @param description
	 * @param debutenchere
	 * @param finenchere
	 * @param prixdepart
	 */
	public Vente(String article, String description, String debutenchere, String finenchere, String prixdepart) {
		this.article = article;
		this.description = description;
		this.debutenchere = debutenchere;
		this.finenchere = finenchere;
		this.prixdepart = prixdepart;
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
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("Vente [article=%s, description=%s, debutenchere=%s, finenchere=%s, prixdepart=%s, id=%s]",
				article, description, debutenchere, finenchere, prixdepart, id);
	}

	
	


}
