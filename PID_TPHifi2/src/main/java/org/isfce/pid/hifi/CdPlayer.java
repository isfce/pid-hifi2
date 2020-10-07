package org.isfce.pid.hifi;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CdPlayer implements ICdPlayer {
	// Disque
	private ICd cd;

	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	// piste courante
	private int current;

	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	// Nombre de pistes -1
	private int maxPistes;

	/**
	 * Renvoie un texte avec le morceau ou NODISK
	 */
	@Override
	public String getMusic() {
		if (cd == null)
			return "NO DISK";
		return cd.play(current);
	}

	/**
	 * Charge un CD
	 * 
	 * @param cd
	 */
	public void setCd(ICd cd) {
		current = 0;
		if (cd != null) {
			maxPistes = cd.getNbPistes() - 1;
			System.out.println("Chargement d'un CD: " + cd.getTitre());
		} else {
			maxPistes = 0;
			System.out.println("Retire le CD");
		}
		this.cd = cd;
	}

	@Override
	public String next() {
		current = Math.min(current + 1, maxPistes);
		return getMusic();
	}

	@Override
	public String previous() {
		current = Math.max(current - 1, 0);
		return getMusic();
	}

	@Override
	public String position(int nbr) {
		if (nbr > 0 && nbr <= maxPistes)
			current = nbr;
		return getMusic();
	}

	@Override
	public void autoPlay() {
		if (getCd() != null) {
			for (int piste = 1; piste < getCd().getNbPistes(); piste++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println("piste: " + next());
			}
			System.out.println("Fin Disque");
		} else
			System.out.println("NO CD");

	}

}
