package org.isfce.pid.hifi;

import lombok.Data;

@Data
public class Ampli implements IAmpli {
	private final int DEFAUT_VOLUME = 5;
	private final Sources DEFAUT_SOURCE = Sources.CD;

	private int volume;

	private Sources source;

	private ICdPlayer cdPlayer;

	private Tuner tuner;

	public Ampli() {
		volume = DEFAUT_VOLUME;
		source = DEFAUT_SOURCE;
	}

	public Ampli(int volume, ICdPlayer cdPlayer, Tuner tuner) {
		this.volume = volume;
		this.cdPlayer = cdPlayer;
		this.tuner = tuner;
		source = DEFAUT_SOURCE;
	}

	// Connexion d'un lecteur de CD
	/*
	 * (non-Javadoc)
	 * 
	 * @see hifi.IAmpli#setCdPlayer(hifi.CdPlayer)
	 */
	@Override
	public void setCdPlayer(ICdPlayer cdPlayer) {
		setAppareil(this.cdPlayer, cdPlayer, Sources.CD);
		this.cdPlayer = cdPlayer;
	}
		
	// connexion d'un Tuner
	/*
	 * (non-Javadoc)
	 * 
	 * @see hifi.IAmpli#setTuner(hifi.Tuner)
	 */
	@Override
	public void setTuner(Tuner tuner) {
		setAppareil(this.tuner, tuner, Sources.TUNER);
		this.tuner = tuner;
	}

	// Gère l'affichage en fonction
	private String setAppareil(ISource anc, ISource nouv, Sources source) {
		if (anc == null && nouv != null)
			return "Connexion d'un " + source.name();
		else if (anc != null && nouv == null)
			return "Déconnexion du " + source.name();
		else if (anc != null && !anc.equals(nouv))
			return "Remplacement du " + source.name();
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hifi.IAmpli#setVolume(int)
	 */
	@Override
	public void setVolume(int volume) {
		volume = Math.min(Math.max(volume, 0), 10);
		if (this.volume != volume) {
			this.volume = volume;
			System.out.println("Changement du volume ==> Niveau: " + this.volume);
		}

	}

	// Changement de source
	
	@Override
	public void setSource(Sources source) {
		System.out.println("Sélection de la source: " + source);
		this.source = source;
		afficheSource();
	}

	/*
	 * Affiche la lecture en cours
	 * 
	 */
	@Override
	public void afficheSource() {
		ISource s;
		switch (source) {
		case CD:
			s = cdPlayer;
			break;
		case TUNER:
			s = tuner;
			break;
		default:
			s = null;
			source = null;
		}
		System.out.println(s == null ? "No Source" : s.getMusic() + " Volume :" + volume);
	}

	

}
