package com.gcu.utility;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> cart = new ArrayList<Product>();
/**
 * Allows the user to get the cart list variable
 * @return cart
 */
	public ArrayList<Product> getCart() {
		return cart;
	}
/**
 * Allows the user to change the cart list variable
 * @param cart
 * ArrayList
 */
	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}
/**
 * Creates a new cart object
 * @param cart
 * ArrayList
 */
	public Cart() {
		
	}
	
	/**
	 * Removes a desired product from the cart
	 * @param p
	 * Product
	 */
	public void cancelPurchase(int i) {
			cart.remove(i);
			
			
	for(Product x : cart) {
		if(x.getIndex()-1 != cart.indexOf(x)) {
			x.setIndex(x.getIndex()-1);
			}
		}
	}
		
	/**
	 * Overrides the current toString method to print the contents of the cart
	 * @return String
	 */
	public String toString() {
		String text = "Current cart: ";
		for(Product p: cart) {
			text+= p.toString();
			
			text+= "\n";
		}
		return text;
		
	}
	
	

}
