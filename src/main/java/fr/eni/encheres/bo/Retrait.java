package fr.eni.encheres.bo;

public class Retrait {

	private int no_article;
	private String rue;
	private String code_postal;
	private String ville;
	/**
	 * @param no_article
	 * @param rue
	 * @param code_postal
	 * @param ville
	 */
	public Retrait(int no_article, String rue, String code_postal, String ville) {
		this.no_article = no_article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	/**
	 * @return the no_article
	 */
	public int getNo_article() {
		return no_article;
	}
	/**
	 * @param no_article the no_article to set
	 */
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}
	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
}
