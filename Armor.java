package com.gcu.utility;

public class Armor extends Product {

	private int protection;
	public Armor() {
		super();
		protection = 0;
	}
	public Armor(int index, String name, String desc, double price, int quantity, int protection) {
		super(index, name, desc, price, quantity);
		// TODO Auto-generated constructor stub
		this.setProtection(protection);
	}
	/**
	 * returns the protection factor of an armor object
	 * @return int
	 */
	public int getProtection() {
		return protection;
	}
	/**
	 * Change the protection factor
	 * @param protection
	 */
	public void setProtection(int protection) {
		this.protection = protection;
	}
	@Override
	public String toString() {
		return super.toString() +" protection power: "+protection;
	}

}
