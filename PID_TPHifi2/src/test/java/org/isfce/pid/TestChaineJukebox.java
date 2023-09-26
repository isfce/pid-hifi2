package org.isfce.pid;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.isfce.pid.hifi.Ampli;
import org.isfce.pid.hifi.ICd;
import org.isfce.pid.hifi.IChargeur;
import org.isfce.pid.hifi.MultiCdPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"test","jukebox"})
class TestChaineJukebox {
	@Autowired
	ApplicationContext contexte;

	@Test
	void testBeans() {
		assertTrue(contexte.containsBean("monCD"));
		ICd monCD = (ICd) contexte.getBean("monCD");
		assertTrue(contexte.containsBean("ampli"));
		Ampli ampli = (Ampli) contexte.getBean("ampli");
		assertNotNull(ampli.getTuner());
		assertNotNull(ampli.getCdPlayer());
		assertTrue(ampli.getCdPlayer() instanceof MultiCdPlayer);
		MultiCdPlayer mcdp = (MultiCdPlayer) ampli.getCdPlayer();
		assertTrue(contexte.containsBean("chargeurBeatles"));
		IChargeur cb = (IChargeur) contexte.getBean("chargeurBeatles");
		assertTrue(mcdp.getChargeur() == cb);
	}

}
