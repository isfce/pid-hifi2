package org.isfce.pid.hifi;

import java.util.List;

/**
 * Contient une liste de CDs
 * Pour un lecteur MultiCDs par exemple
 * 
 * @author Didier
 *
 */

public class ChargeurCds implements IChargeur {
	/**
	 * Disque courant
	 */
	private int current = 0;
	/**
	 * Liste des CD
	 */
	private final List<ICd> liste;
/**
 * Création d'un chargeur avec be 
 * @param liste
 * @throws Exception 
 */
	public ChargeurCds(List<ICd> liste) throws Exception {
		if (liste==null || liste.size()==0)
			throw new Exception(" Un chargeur de CD doit recevoir une liste de disque non vide");

		this.liste = liste;
	}

	/**
	 * Chargement circulaire des disques
	 */
	@Override
	public ICd nextDisque() {
		current = (current + 1) % liste.size();
		return liste.get(current);
	}

	/**
	 * Chargement circulaire des disques
	 */
	@Override
	public ICd previousDisque() {
		current = (current - 1);
		if (current < 0)
			current = liste.size() - 1;
		return liste.get(current);
	}

	@Override
	public int getNBDisques() {
		return liste.size();
	}

	@Override
	public ICd getDisque(int i) {
		i--;// ajuste pour être entre 0 et ..
		if (i >= 0 && i < liste.size())
			current = i;
		return liste.get(current);
	}

}
