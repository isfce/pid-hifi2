package org.isfce.pid.hifi;

public interface IAmpli {

	public enum Sources {
		CD, TUNER
	}

	// Connexion d'un lecteur de CD
	void setCdPlayer(ICdPlayer cdPlayer);

	ICdPlayer getCdPlayer();

	// connexion d'un Tuner
	void setTuner(Tuner tuner);

	Tuner getTuner();

	// Gestion du volume
	void setVolume(int volume);

	int getVolume();

	// Changement de source
	void setSource(Sources source);

	Sources getSource();

	/**
	 * Affiche un texte précisant ce qu'on écoute
	 */
	void afficheSource();

}