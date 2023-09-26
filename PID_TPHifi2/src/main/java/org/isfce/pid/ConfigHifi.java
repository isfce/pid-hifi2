package org.isfce.pid;

import java.io.IOException;

import org.isfce.pid.hifi.Ampli;
import org.isfce.pid.hifi.CdPlayer;
import org.isfce.pid.hifi.ChargeurCdFactory;
import org.isfce.pid.hifi.DisqueCD;
import org.isfce.pid.hifi.IAmpli;
import org.isfce.pid.hifi.ICd;
import org.isfce.pid.hifi.ICdPlayer;
import org.isfce.pid.hifi.IChargeur;
import org.isfce.pid.hifi.MultiCdPlayer;
import org.isfce.pid.hifi.Tuner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

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

	@Bean("CdPlayer")
	CdPlayer getCdPlayer() {
		CdPlayer cdp = new CdPlayer();
		cdp.setCd(getMonCd());
		return cdp;
	}
	
	@Bean("multiCdPlayer")
	@Profile("jukebox")
	@Primary
	MultiCdPlayer getMultiCd() {
		MultiCdPlayer mcdp=new MultiCdPlayer();
		mcdp.setChargeur(getBeatles());
		return mcdp;
	}

    @Bean("ampli")
    IAmpli getAmpli(Tuner tuner, ICdPlayer cd) {
		Ampli a = new Ampli();
		a.setTuner(tuner);
		a.setCdPlayer(cd);
		return a;
	}
}
