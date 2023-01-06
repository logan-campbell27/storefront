package com.gcu.utility;

import java.io.IOException;
import java.util.ArrayList;



public class InventoryAdminThread extends Thread {
	
		
		private ArrayList<Product> inventory;

		
		public InventoryAdminThread(ArrayList<Product> inventory) {
			super();
			this.inventory = inventory;
		}
		
		
	    public ArrayList<Product> getInventory() {
			return inventory;
		}
	    


		
        /**
         * Starts the admin object to run a network
         */
		public void run() {
		InventoryAdmin admin = new InventoryAdmin();
		
		try {
			admin.start(6666,this.inventory);
			for(Product p: inventory) {
				System.out.println(p.toString());
			}
			admin.cleanup();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
