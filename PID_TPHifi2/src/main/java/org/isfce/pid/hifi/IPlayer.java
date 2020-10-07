package org.isfce.pid.hifi;
/**
 * Commande pour changer de morceau sur un appareil
 * @author Didier
 *
 */
public interface IPlayer {
	/**
	 * Passe à la piste suivante
	 * @return le nom du morceau
	 */
	String next();
	/**
	 * Passe à la piste précédente
	 * @return le nom du morceau
	 */
	String previous();
	/**
	 * Se positionne sur le numéro
	 * @param numéro valide
	 * @return le nom du morceau
	 */
	String position(int nbr);
}
