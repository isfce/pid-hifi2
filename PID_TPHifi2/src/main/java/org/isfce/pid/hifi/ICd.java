package org.isfce.pid.hifi;

public interface ICd {
	/**
	 * Retourne le morceau indiqué
	 * 
	 * @param i de 0 à nbPiste-1
	 * @return
	 */
	String play(int i);

	/**
	 * Titre du disque
	 * 
	 * @return Titre du disque
	 */
	String getTitre();

	/**
	 * 
	 * @return nombre de pistes du disque
	 */
	int getNbPistes();
}
