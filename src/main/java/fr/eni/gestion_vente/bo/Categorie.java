package fr.eni.gestion_vente.bo;

public class Categorie {

	private int numcatego;
	private String libelle;
	/**
	 * @param numcatego
	 * @param libelle
	 */
	public Categorie(int numcatego, String libelle) {
		this.numcatego = numcatego;
		this.libelle = libelle;
	}
	/**
	 * @return the numcatego
	 */
	public int getNumcatego() {
		return numcatego;
	}
	/**
	 * @param numcatego the numcatego to set
	 */
	public void setNumcatego(int numcatego) {
		this.numcatego = numcatego;
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
		return String.format("Categorie [numcatego=%s, libelle=%s]", numcatego, libelle);
	}
	
	
	
}
