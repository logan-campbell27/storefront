package com.gcu.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArmorTest {

	@Test
	public void testArmorIntStringStringDoubleIntInt() {
		Armor a = new Armor(1, "Shin guard","Not very useful",5.5,5,2);
	}

	@Test
	public void testProductIntStringStringDoubleInt() {
		Product p = new Product(1, "Shin guard","Not very useful",5.5,5);

	}

}
