package com.gcu.utility;

public class Weapon extends Product {

	private int damage;
	public Weapon() {
		super();
		damage = 0;
	}
	public Weapon(int index, String name, String desc, double price, int quantity, int damage) {
		super(index, name, desc, price, quantity);
		this.setDamage(damage);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Gets the damage the weapon can do
	 * @return int
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Change the damage of a weapon
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	@Override
	public String toString() {
		return super.toString()+" damage: "+damage;
	}

}
