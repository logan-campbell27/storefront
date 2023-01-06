package com.gcu.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	@Test
	public void testWeaponIntStringStringDoubleIntInt() {
		Weapon w = new Weapon(1, "axe","Small blade, big power",55.5,5,10);
	}

	@Test
	public void testProductIntStringStringDoubleInt() {
		Product p = new Product(1, "axe","Small blade, big power",55.5,5);
	}

}
