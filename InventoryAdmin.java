package com.gcu.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public class InventoryAdmin {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	/**
	 * Starts the port allowing it to communicate with the admin client
	 * @param port
	 * @param inventory
	 * @throws IOException
	 */
	public void start(int port, ArrayList<Product> inventory) throws IOException{
		//System.out.println("Waiting for client connection.........");
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		//System.out.println("Received a client connection on port "+clientSocket.getLocalPort());
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		String inputLine;
		while((inputLine = in.readLine()) != null) {
			if(".".equals(inputLine)) {
				System.out.println("Got a message to shut the server down");
				
				out.println("QUIT");
				break;
			}
			
			else{
				 //System.out.println("Got a message of: "+inputLine);
				 Product p = objectMapper.readValue(inputLine, Product.class);
                 boolean sameName = false;
				 for(Product x:inventory) {
					
					 if(x.getName().equals(p.getName())) {
						 sameName = true;
						 break;
					 }
				 }
				 if(!sameName) {
					 p.setIndex(inventory.size()+1);
					 inventory.add(p);

				 }
				 out.println("OK");
			}
		}		
		System.out.println("Server is shut down");

	}
	/**
	 * closes all servers, socket, readers and writers
	 * @throws IOException
	 */
	public void cleanup() throws IOException{
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	
}
