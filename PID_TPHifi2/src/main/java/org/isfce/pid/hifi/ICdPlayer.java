package org.isfce.pid.hifi;

public interface ICdPlayer extends ISource, IPlayer{

	ICd getCd();
	
	//lance la lecteur automatique de tous les morceaux des CDs chargés
	void autoPlay();

}