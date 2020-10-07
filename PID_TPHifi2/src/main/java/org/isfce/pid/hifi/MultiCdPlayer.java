package org.isfce.pid.hifi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MultiCdPlayer extends CdPlayer implements IChargeur {

	private IChargeur chargeur;

	/**
	 * Chargement d'un chargeur de CD
	 * 
	 * @param chargeur
	 */
	public void setChargeur(IChargeur chargeur) {
		if (this.chargeur != chargeur) {
			this.chargeur = chargeur;
			setCd(null);
			if (chargeur != null) {
				System.out.println("Installation Chargeur");
				getDisque(1);// Charge le premier disque
			} else {
				System.out.println("Plus de Chargeur");
			}
		}
	}

	@Override
	public ICd nextDisque() {
		ICd cd = null;
		if (chargeur != null) {// charge le prochain disque
			cd = chargeur.nextDisque();
			super.setCd(cd);
		}
		return cd;

	}

	@Override
	public ICd previousDisque() {
		ICd cd = null;
		if (chargeur != null) {// charge le disque précédent
			cd = chargeur.previousDisque();
			super.setCd(cd);
		}
		return cd;
	}

	@Override
	public int getNBDisques() {
		return chargeur == null ? 0 : chargeur.getNBDisques();
	}

	@Override
	public ICd getDisque(int i) {
		ICd cd = null;
		if (chargeur != null) {// charge le disque i
			cd = chargeur.getDisque(i);
			super.setCd(cd);
		}
		return cd;
	}

	@Override
	public void autoPlay() {
		for (int i = 1; i <= getNBDisques(); i++) {
			getDisque(i);// charge le disque i
			super.autoPlay(); // lance la lecture
		}
		System.out.println("FIN du chargeur");
	}

}
