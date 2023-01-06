package com.gcu.utility;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StoreInventoryTest {

	@Test
	public void testAddProduct() {
		ArrayList<Product> testList = new ArrayList<Product>();
		Product p = new Product(1, "axe","Small blade, big power",55.5,5);

		testList.add(p);
	}

	@Test
	public void testPurchase() {
		ArrayList<Product> testList = new ArrayList<Product>();
		Product p = new Product(1, "axe","Small blade, big power",55.5,5);

		testList.add(p);
		
		testList.remove(0);
	}

	@Test
	public void testCancelPurchase() {
		ArrayList<Product> testList = new ArrayList<Product>();
		Product p = new Product(1, "axe","Small blade, big power",55.5,5);

		testList.add(p);
	}

}
