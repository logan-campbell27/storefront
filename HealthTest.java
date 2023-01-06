package com.gcu.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class HealthTest {

	@Test
	public void testHealthIntStringStringDoubleIntInt() {
		Health h = new Health(1, "cotton swab","mostly useless",55.5,5,2);
	}

	@Test
	public void testProductIntStringStringDoubleInt() {
		Product p = new Product(1, "cotton swab","mostly useless",55.5,5);

	}

}
