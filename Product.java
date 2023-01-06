package com.gcu.utility;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")

public class Product{
	private String name;
	private String desc;
	private double price;
	private int quantity;
	private int index;
	public Product() {
		name ="";
		desc = "";
		price = 0;
		quantity = 0;   
		index = 0;
	}
	/**
	 * Generates a new product
	 * @param index
	 * int
	 * @param name
	 * name
	 * @param desc
	 * String
	 * @param price
	 * double
	 * @param quantity
	 * int
	 */
	public Product(int index, String name, String desc, double price, int quantity) {
		this.index = index;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}
	/**
	 * Allows the user to get the index variable
	 * @return int
	 */
	public int getIndex() {
		return index;
	}
/**
 * Allows the user to change the index variable
 * @param index
 * int
 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * Allows the user to get the name variable
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * Allows the user to change the name variable
	 * @param name
	 * String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Allows the user to get the description variable
	 * @return String
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * Allows the user to change the description variable
	 * @param desc
	 * String
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * Allows the user to get the price variable
	 * @return double
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Allows the user to change the price variable
	 * @param price
	 * double
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Allows the user to get the quantity variable
	 * @return int
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Allows the user to change the quantity variable
	 * @param quantity
	 * int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Index: "+index +" Name: "+name+" Description: "+desc+" Price: "+price+" Current Stock: "+quantity;
				
	}
	
	
	

}
