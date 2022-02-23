package fr.eni.encheres.bo;

public class Categorie {

	private int no_categorie;
	private String libelle;
	/**
	 * @param numCatego
	 * @param libelle
	 */
	public Categorie(int numCatego, String libelle) {
		this.no_categorie = numCatego;
		this.libelle = libelle;
	}
	public Categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	/**
	 * @return the numcatego
	 */
	public int getNumcatego() {
		return no_categorie;
	}
	/**
	 * @param numcatego the numcatego to set
	 */
	public void setNumcatego(int numcatego) {
		this.no_categorie = numcatego;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return String.format("Categorie [numcatego=%s, libelle=%s]", no_categorie, libelle);
	}
	
	
	
}
