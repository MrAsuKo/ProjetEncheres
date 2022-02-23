package fr.eni.encheres.bo;

public class Utilisateur {

	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String cp;
	private String ville;
	private String mdp;
	private int credit;
	private boolean administrateur;
	private boolean trouve;
	
	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param cp
	 * @param ville
	 * @param mdp
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String mdp) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.mdp = mdp;
	}
	
	public Utilisateur(String pseudo, String email, String mdp) {
		this.pseudo = pseudo;
		this.email = email;
		this.mdp = mdp;
	}
	
	public Utilisateur(int noUtilisateur, String pseudo) {
		this.id = noUtilisateur;
		this.pseudo = pseudo;
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String mdp, int credit, boolean administrateur) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String mdp, int credit, boolean administrateur, boolean trouve) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.administrateur = administrateur;
		this.trouve = trouve;
	}
	
	

	public Utilisateur(String pseudo) {
		this.pseudo = pseudo;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(int no_utilisateur, String pseudo, String telephone) {
		this.pseudo=pseudo;
		this.telephone=telephone;
		this.id=no_utilisateur;
	}

	public Utilisateur(String pseudo, String mdp) {
		this.pseudo=pseudo;
		this.mdp=mdp;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
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

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", telephone=" + telephone + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + ", mdp=" + mdp
				+ ", credit=" + credit + ", administrateur=" + administrateur + "]";
	}

	public void setTrouve(boolean trouve) {
		this.trouve = trouve;
		
	}

	/**
	 * @return the trouve
	 */
	public boolean isTrouve() {
		return trouve;
	}
	
	
}
