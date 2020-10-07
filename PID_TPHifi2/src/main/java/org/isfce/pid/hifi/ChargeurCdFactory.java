package org.isfce.pid.hifi;

import java.io.IOException;
import java.util.Properties;
import java.util.stream.Collectors;

public class ChargeurCdFactory {
/**
 * Fabrique qui construit un chargeur avec une liste de CD à partir d'un fichier
 * l'organisation du fichier étant
 * nomDisque= liste des morceaux séparés avec une virgule
 *  Exemple d'appel:
 *   ChargeurCdFactory.createChargeur("/hifi/CDBeatles.properties");
 *   
 * @param file
 * @return
 * @throws IOException
 */
	public static IChargeur createChargeur(String file) throws IOException {
		IChargeur chargeur=null;
		
		Properties disques = new Properties();
		//Charge dans un dictionnaire (titre==>liste des morceaux séparés par une virgule)
		disques.load(ChargeurCdFactory.class.getResourceAsStream(file));
		try {
			chargeur=new ChargeurCds(disques.keySet().stream()
					.map(d -> new DisqueCD((String) d, disques.getProperty((String) d))).collect(Collectors.toList()));
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return chargeur;
	}
}
