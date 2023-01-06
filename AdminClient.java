package com.gcu.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AdminClient {
	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	/**
	 * Starts up a network using the ip and port parameters
	 * @param ip
	 * @param port
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException{
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	/**
	 * Sends the desired message over the connection
	 * @param msg
	 * @return
	 * @throws IOException
	 */
	public String sendMessage(String msg) throws IOException{
		out.println(msg);
		
		return in.readLine();
	}
	/**
	 * closes all writers, readers, and socket
	 * @throws IOException
	 */
	public void cleanup() throws IOException{
		in.close();
		out.close();
		clientSocket.close();
	}
	/**
	 * Reads from desired file and returns a list of products
	 * @param filename
	 * @return ArrayList<Product>
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
	/**
	 * Iterates through the inventory parameter and utilizes the sendMessage function to send a message
	 * @param liveInventory
	 * @param o
	 * @param print
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void iterate(ArrayList<Product>liveInventory, ObjectMapper o, boolean print) throws InterruptedException, IOException {
		String response;
		for(Product p:liveInventory) {
			String message = o.writeValueAsString(p);
			
			response = this.sendMessage(message);
			if(print) {
				System.out.println("Server response was "+response);
				System.out.println(message);
			}
			
			if(response.equals("q")) {
				break;
			}
			Thread.sleep(500);
				
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		AdminClient client = new AdminClient();

		System.out.println("Client starts");
		client.start("127.0.0.1",6666);
		
		
		ArrayList<Product> liveInventory = client.readFromFile("Inventory.json");
		
		
		
		
		/*
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
    	*/
    	
        
		
    	ObjectMapper objectMapper = new ObjectMapper();
    	Scanner scan = new Scanner(System.in);
    	String choice = "A";
    	
    	
    	while(choice != "Q") {
    		System.out.println("Welcome to the admin application. Select a command");
        	System.out.println("U: add to the inventory");
        	System.out.println("R: Read from current inventory");
        	System.out.println("Q: Quit admin app");
        	choice = scan.nextLine();
      	switch(choice) {
    	case "R":
    		/*String response;
    		for(Product p:liveInventory) {
    			String message = objectMapper.writeValueAsString(p);
    			
    			response = client.sendMessage(message);
    			
    			System.out.println("Server response was "+response);
    			System.out.println(message);
    			if(response.equals("q")) {
    				break;
    			}
    			Thread.sleep(1000);
    				
    		}
    		*/
    		client.iterate(liveInventory, objectMapper,true);
    		
    		break;
    		
    	case "U":
    		Scanner tryScan = new Scanner(System.in);
    		System.out.println("Enter the product class");
    		System.out.println("1: Weapon. 2: Health. 3: Armor");
    		int classType = scan.nextInt();
    		switch(classType) {
    		case 1:
    			Weapon w = new Weapon();
    			w.setIndex(0);
    			System.out.println("Name: ");
    			String name = tryScan.nextLine();
    			System.out.println("Description: ");
    			String desc = tryScan.nextLine();
    			System.out.println("Price: ");
    			double price = tryScan.nextDouble();
    			System.out.println("Quantity: ");
    			int quantity = tryScan.nextInt();
    			System.out.println("Damage: ");
    			int damage = tryScan.nextInt();
    			w.setName(name);
    			w.setDesc(desc);
    			w.setPrice(price);
    			w.setQuantity(quantity);
    			w.setDamage(damage);
    			liveInventory.add(w);
    			break;
    			
    		case 2:
    			Health h = new Health();
    			h.setIndex(0);

    			System.out.println("Name: ");

    			String n = tryScan.nextLine();
    			System.out.println("Description: ");
    			String de = tryScan.nextLine();
    			System.out.println("Price: ");
    			double p = tryScan.nextDouble();
    			System.out.println("Quantity: ");
    			int q = tryScan.nextInt();
    			System.out.println("Healing: ");
    			int health = tryScan.nextInt();
    			h.setName(n);
    			h.setDesc(de);
    			h.setPrice(p);
    			h.setQuantity(q);
    			h.setHealing(health);
    			liveInventory.add(h);

    			break;
    		case 3:
    			Armor ab = new Armor();
    			ab.setIndex(0);

    			System.out.println("Name: ");
    			System.out.println();

    			String na = tryScan.nextLine();
    			System.out.println("Description: ");
    			String des = tryScan.nextLine();
    			System.out.println("Price: ");
    			double pr = tryScan.nextDouble();
    			System.out.println("Quantity: ");
    			int qu = tryScan.nextInt();
    			System.out.println("Protection: ");
    			int pro = scan.nextInt();
    			ab.setName(na);
    			ab.setDesc(des);
    			ab.setPrice(pr);
    			ab.setQuantity(qu);
    			ab.setProtection(pro);
    			liveInventory.add(ab);

    			break;
 
    	
    			
    		default:
    			System.out.println("invalid input");
    			break;
    		}
    		System.out.println("Updating store inventory...");
    		client.iterate(liveInventory, objectMapper,false);
    		break;
    		
    	case "Q":
    		client.cleanup();
    		choice = "Q";
    		break;
    	}
      	
    	}
    	

		
	}
	
}
