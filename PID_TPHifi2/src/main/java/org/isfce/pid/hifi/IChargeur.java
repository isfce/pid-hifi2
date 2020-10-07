package org.isfce.pid.hifi;

public interface IChargeur {

	ICd nextDisque();

	ICd previousDisque();

	int getNBDisques();

	/**
	 * retourne le disque de position i
	 * 
	 * @param i
	 *            valeur de 1 à NbDisques
	 * @return
	 */
	ICd getDisque(int i);

}
