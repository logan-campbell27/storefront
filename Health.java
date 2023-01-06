package com.gcu.utility;

public class Health extends Product {

	private int healing;
	public Health() {
		super();
		healing = 0;
	}
	public Health(int index, String name, String desc, double price, int quantity, int healing) {
		super(index, name, desc, price, quantity);
		// TODO Auto-generated constructor stub
		this.setHealing(healing);
	}
	/**
	 * Gets the healing power of a health product
	 * @return int
	 */
	public int getHealing() {
		return healing;
	}
	/**
	 * Change the value of healing power
	 * @param healing
	 */
	public void setHealing(int healing) {
		this.healing = healing;
	}
	@Override
	public String toString() {
		return super.toString()+" healing power: "+healing;
	}

}
