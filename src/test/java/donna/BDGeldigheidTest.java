package donna;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BDGeldigheidTest {

	/**
	 * Test voor constructor {@link BDGeldigheid#BDGeldigheid(String)} en
	 * {@link BDGeldigheid#isGeldig(Weekdag)}
	 */
	@Test
	public void isGeldig() {
		BDGeldigheid doordeweekseGeldigheid = new BDGeldigheid("JJJJJNN");
		assertTrue(doordeweekseGeldigheid.isGeldig(Weekdag.MA));
		assertTrue(doordeweekseGeldigheid.isGeldig(Weekdag.DI));
		assertTrue(doordeweekseGeldigheid.isGeldig(Weekdag.WO));
		assertTrue(doordeweekseGeldigheid.isGeldig(Weekdag.DO));
		assertTrue(doordeweekseGeldigheid.isGeldig(Weekdag.VR));
		assertFalse(doordeweekseGeldigheid.isGeldig(Weekdag.ZA));
		assertFalse(doordeweekseGeldigheid.isGeldig(Weekdag.ZO));

		BDGeldigheid maandagGeldigheid = new BDGeldigheid("JNNNNNN");
		assertTrue(maandagGeldigheid.isGeldig(Weekdag.MA));
		assertFalse(maandagGeldigheid.isGeldig(Weekdag.DI));
		assertFalse(maandagGeldigheid.isGeldig(Weekdag.WO));
		assertFalse(maandagGeldigheid.isGeldig(Weekdag.DO));
		assertFalse(maandagGeldigheid.isGeldig(Weekdag.VR));
		assertFalse(maandagGeldigheid.isGeldig(Weekdag.ZA));
		assertFalse(maandagGeldigheid.isGeldig(Weekdag.ZO));
	}

	/**
	 * test voor {@link BDGeldigheid#doorsnede(BDGeldigheid)}
	 */
	@Test
	public void doorsnede() {
		BDGeldigheid geldigheid1 = new BDGeldigheid("JJJJJNN");
		BDGeldigheid geldigheid2 = new BDGeldigheid("NNNNJJJ");
		BDGeldigheid doorsnede = geldigheid1.doorsnede(geldigheid2);

		assertEquals("NNNNJNN", doorsnede.toJNstring());
	}

	/**
	 * test voor {@link BDGeldigheid#verschuiven(int)}
	 */
	@Test
	public void verschuiven() {

		BDGeldigheid starter = new BDGeldigheid("NNNNJNN");

		BDGeldigheid verschuivenPlus = starter.verschuiven(2);
		BDGeldigheid verschuivenMinus= starter.verschuiven(-2);

		assertEquals("NNNNNNJ", verschuivenPlus.jnString);
		assertEquals("NNJNNNN", verschuivenMinus.jnString);


	}
}
