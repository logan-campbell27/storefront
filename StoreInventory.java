package com.gcu.utility;

import java.util.ArrayList;

public class StoreInventory{
	
	
	private ArrayList<Product> inventory = new ArrayList<Product>();
	/**
	 * Creates a new store inventory
	 * @param inventory
	 * ArrayList
	 */
	public StoreInventory() {
		
	}
	
    public void populate() {
    	Weapon a = new Weapon(1, "Mace", "Spikey ball", 20.99 , 5, 20);
    	Weapon b = new Weapon(2,"Sword", "Bladed weapon", 50.99 , 3, 50);
    	Health c = new Health(3,"Bandage", "First aid", 10.99 , 10, 10);
    	Health d = new Health(4,"Potion", "Unknown creator", 30.99 , 2, 20);
    	Armor e = new Armor(5,"Chestplate", "Bodily protection", 35.99 , 3, 30);
    	Armor f = new Armor(6,"Helmet", "Watch the head", 15.99 , 7, 10);
    	inventory.add(a);
    	inventory.add(b);
    	inventory.add(c);
    	inventory.add(d);
    	inventory.add(e);
    	inventory.add(f);

    }
    
	
/**
 * Gets the inventory ArrayList
 * @return ArrayList
 */
	public ArrayList<Product> getInventorty() {
		return inventory;
	}
/**
 * Can set the inventory to a new inventory
 * @param inventory
 * ArrayList
 */
	public void setInventorty(ArrayList<Product> inventory) {
		this.inventory = inventory;
	}
	/**
	 * Adds a product to the inventory
	 * @param p
	 */
	public void addProduct(Product p) {
		inventory.add(p);
	}
	/**
	 * Removes a product from the inventory, and it is moved to the cart in another class
	 * @param p
	 * Product
	 */
	public void purchase(Product p, Cart c) {
		if(p.getQuantity()>0) {
			int holder = p.getQuantity()-1;
			Product newProduct = new Product(c.getCart().size()+1, p.getName(), p.getDesc(), p.getPrice(), 1);
			c.getCart().add(newProduct);
			p.setQuantity(holder);

		}
		else {
			System.out.println("Product is out of stock");
		}
	}
	/**
	 * Cancels the purchase of an item transferring it to the store inventory
	 * @param p
	 * Product
	 */
	public void cancelPurchase(Product p) {
		for(Product x : inventory) {
			if(x.getName() == p.getName()) {
				x.setQuantity(x.getQuantity()+1);
			}
		}
	}
	
	
	

	
	/**
	 * Overwrites the current toString method to print the stores inventory
	 * @return String
	 */
	@Override
	public String toString() {
		String text = "";
		for(Product p : inventory){
			text+=p.toString();
			text+="\n";
		}
		return text;
	}

}
