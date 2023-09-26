package org.isfce.pid;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.isfce.pid.hifi.Ampli;
import org.isfce.pid.hifi.CdPlayer;
import org.isfce.pid.hifi.ICd;
import org.isfce.pid.hifi.MultiCdPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class TestChaineClassique {
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
		assertFalse(ampli.getCdPlayer() instanceof MultiCdPlayer);
		assertTrue(ampli.getCdPlayer().getCd()==monCD);
	}

}
