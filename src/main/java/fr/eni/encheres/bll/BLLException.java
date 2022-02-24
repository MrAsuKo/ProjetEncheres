package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {

	private List<String> erreurs;
	
	/**
	 * @param message
	 */
	public BLLException(String message) {
		super(message);
		
		erreurs = new ArrayList<String>();
	}

	public void ajouterErreur(String msg) {
		erreurs.add(msg);
	}
	
	public boolean hasErreur() {
		return !erreurs.isEmpty();
	}

	/**
	 * @return the erreurs
	 */
	public List<String> getErreurs() {
		return erreurs;
	}
	
	
	
}
