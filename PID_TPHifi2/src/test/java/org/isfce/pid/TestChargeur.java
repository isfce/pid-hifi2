package org.isfce.pid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.isfce.pid.hifi.ICd;
import org.isfce.pid.hifi.IChargeur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class TestChargeur {
	@Autowired
	ApplicationContext contexte;

	@Test
	void testChargeurs() {
		assertTrue(contexte.containsBean("chargeurBeatles"));
		assertTrue(contexte.containsBean("chargeurStones"));

		IChargeur cb = (IChargeur) contexte.getBean("chargeurBeatles");
		IChargeur cs = (IChargeur) contexte.getBean("chargeurStones");
		assertEquals(3, cb.getNBDisques());
		assertEquals(2, cs.getNBDisques());
	}

	@Test
	void testMonCD(@Autowired(required = false) ICd monCD) {
		assertNotNull(monCD);
		assertEquals(3,monCD.getNbPistes());
	}	

}
