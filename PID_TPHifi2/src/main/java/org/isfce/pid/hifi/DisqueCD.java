package org.isfce.pid.hifi;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class DisqueCD implements ICd {

	private final String titre;
	private final List<String> pistes;

	/**
	 * Un CD
	 * 
	 * @param titre
	 * @param pistes liste des titres séparés par une virgule
	 */
	public DisqueCD(String titre, String pistes) {
		
		assert null != titre && null != pistes : " Le disque doit avoir un titre et des pistes";
		this.titre = titre;
		this.pistes = Arrays.asList(pistes.split(","));
		
		assert this.pistes.size() > 0 : "Le disque doit avoir au moins un morceau";
	}

	@Override
	public String play(int i) {
		return pistes == null ? "No track" : pistes.get(i);
	}

	@Override
	public int getNbPistes() {

		return pistes == null ? 0 : pistes.size();
	}

}
