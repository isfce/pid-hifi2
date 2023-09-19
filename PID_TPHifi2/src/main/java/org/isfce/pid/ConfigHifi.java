package org.isfce.pid;

import java.io.IOException;

import org.isfce.pid.hifi.ChargeurCdFactory;
import org.isfce.pid.hifi.DisqueCD;
import org.isfce.pid.hifi.ICd;
import org.isfce.pid.hifi.IChargeur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ConfigHifi {
	@Bean("monCD")
	ICd getMonCd() {
		return new DisqueCD("White Album", "The Wall,piste2,piste3");
	}

	@Bean("chargeurBeatles")
	IChargeur getBeatles() {
		IChargeur cb = null;
		try {
			cb = ChargeurCdFactory.createChargeur("/hifi/CDBeatles.properties");
			log.info("Le chargeur Beatles est créé");
		} catch (IOException e) {
			log.error("Problème de chargement du chargeur Beatles");
		}
		return cb;
	}
	
	@Bean("chargeurStones")
	IChargeur getStones() {
		IChargeur cb = null;
		try {
			cb = ChargeurCdFactory.createChargeur("/hifi/CDStones.properties");
			log.info("Le chargeur Stones est créé");
		} catch (IOException e) {
			log.error("Problème de chargement du chargeur Stones");
		}
		return cb;
	}

}
