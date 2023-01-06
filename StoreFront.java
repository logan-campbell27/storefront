package com.gcu.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;


public class StoreFront {
	
	
	private StoreInventory Inventory = new StoreInventory();
	private Cart ShoppingCart = new Cart();
	
	
	
	
	// add a save to file method and a populate inventory method here
	// use jackson libraries to implement this
	/**
	 * Saves products to a JSON file
	 * @param filename
	 * @param p
	 * @param append
	 */
	private static void saveToFile(String filename, Product p, boolean append) {
		PrintWriter pw;
		try {
			
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(p);
			pw.println(json);
			
			pw.close();
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Reads from a JSON file and returns a list of objects from that file
	 * @param filename
	 * @return ArrayList
	 */
	private static ArrayList<Product> readFromFile(String filename){
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			File file = new File(filename);
			Scanner s  = new Scanner(file);
			
			while(s.hasNext()) {
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				Product p = objectMapper.readValue(json, Product.class);
				products.add(p);
			}
			
			s.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Storefront started");
		StoreFront storeFront = new StoreFront();
		// Generate the inventory
		storeFront.Inventory.setInventorty(storeFront.readFromFile("Inventory.json"));
		
		InventoryAdminThread admin = new InventoryAdminThread(storeFront.Inventory.getInventorty());
		
		
		admin.start();
				
		
		
		// begin user experience
		Scanner scan = new Scanner(System.in);

		int escapeKey = -1;
		while(escapeKey != 0) {
			// menu of options
			System.out.println("Welcome to the store! please select which action you would like to do");
			System.out.println("1: Add an item to the cart");
			System.out.println("2: Remove an item from the cart");
			System.out.println("3: View the cart");
			System.out.println("4: View store inventory");
			System.out.println("5: Sort the inventory");
			System.out.println("0: Quit application");
			
			escapeKey = scan.nextInt();
			//Add a product to the cart
			if(escapeKey == 1) {
				
				int product = 0;
				System.out.println(storeFront.Inventory.toString());
				System.out.println("What product would you like?(Type in the index of the product)");
				product=scan.nextInt();
				product -=1 ;
				if(storeFront.Inventory.getInventorty().size() < product || product < 0) {
					System.out.println("Please enter a valid input");
				}
				
				else {
					
					storeFront.Inventory.purchase((Product) storeFront.Inventory.getInventorty().get(product),storeFront.ShoppingCart);
					
					
				}
		  
			}
			// Remove product from the cart
			else if(escapeKey == 2){
				int product = 0;
				System.out.println(storeFront.ShoppingCart.toString());
				System.out.println("What product would you like to remove?(Type in the index of the product)");
				product=scan.nextInt();
				product-=1;
				if(storeFront.ShoppingCart.getCart().size() < product || product < 0) {
					System.out.println("Please enter a valid input");
				}
				else {
					storeFront.Inventory.cancelPurchase(storeFront.ShoppingCart.getCart().get(product));

					storeFront.ShoppingCart.cancelPurchase(product);
					
				}
		  
			}
			// view the shopping cart
			else if(escapeKey == 3) {
				System.out.println(storeFront.ShoppingCart.toString());
				
			}
			// view the inventory
			else if(escapeKey == 4) {
				System.out.println(storeFront.Inventory.toString());
			}
			else if(escapeKey == 5) {
				int count = 0;
				for(Product p : storeFront.Inventory.getInventorty())
			   {
					if(count == 0) {
						StoreFront.saveToFile("Inventory.json", p, false);
						count++;

					}
					else {
						StoreFront.saveToFile("Inventory.json", p, true);
					}
				}
				System.out.println("Select 1 for A->Z, Select 2 for Z->A");
				int organize = scan.nextInt();
				
				ArrayList<Product> inventoryCopy = readFromFile("Inventory.json");
				if(organize == 2) {
					Collections.sort(inventoryCopy, (o1, o2)->{
						int rc = o1.getName().compareTo(o2.getName());
						if(rc == 0) {
							rc = Double.compare(o1.getPrice(),  o2.getPrice());
						}
						return -rc;
					});
					storeFront.Inventory.setInventorty(inventoryCopy);
				}
				else if(organize == 1) {
					Collections.sort(inventoryCopy, (o1, o2)->{
						int rc = o1.getName().compareTo(o2.getName());
						if(rc == 0) {
							rc = Double.compare(o1.getPrice(),  o2.getPrice());
						}
						return -rc;
					});
					Collections.reverse(inventoryCopy);
					storeFront.Inventory.setInventorty(inventoryCopy);
				}
				else {
					System.out.println("Invalid input");
				}
				count = 1;
				for(Product p : storeFront.Inventory.getInventorty()) {
					p.setIndex(count);
					count++;
				}
			}
			
			else if(escapeKey == 0) {
				// add for loop
				int count = 0;
				for(Product p : storeFront.Inventory.getInventorty())
			   {
					if(count == 0) {
						StoreFront.saveToFile("Inventory.json", p, false);
						count++;

					}
					else {
						StoreFront.saveToFile("Inventory.json", p, true);
					}
				}
				
			
			}
			
			
			else if(escapeKey != 0) {
				System.out.println("Please enter a valid input");
			}
		}
		scan.close();
		System.exit(0);
	}

}
