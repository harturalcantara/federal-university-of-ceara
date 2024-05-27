package com.br.geeksforgeeks;

import java.io.*; 
import java.net.*; 

class Servidor { 

	public static void main(String args[]) 
			throws Exception 
	{ 
		System.out.println("server2-aguardando conexao");
		// Create server Socket 
		ServerSocket ss = new ServerSocket(5000); 

		// connect it to client socket 
		Socket s = ss.accept(); 
		System.out.println("Connection established"); 

		// to send data to the client 
		PrintStream ps 
		= new PrintStream(s.getOutputStream()); 

		// to read data coming from the client 
		BufferedReader br 
		= new BufferedReader( 
				new InputStreamReader( 
						s.getInputStream())); 

		// to read data from the keyboard 
		BufferedReader kb 
		= new BufferedReader( 
				new InputStreamReader(System.in)); 

		// server executes continuously 
		while (true) { 

			String recebido, str1; 

			// repeat as long as the client 
			// does not send a null string 

			// read from client 
			while ((recebido = br.readLine()) != null) {
				
				System.out.println("\nRecebido do cliente: " + recebido);
				recebido = "";
				
				System.out.print("Digite uma msg para o cliente: ");
				str1 = "";
				str1 = kb.readLine(); 
				
				ps 
				= new PrintStream(s.getOutputStream()); 
				// send to client
				br 
				= new BufferedReader( 
						new InputStreamReader( 
								s.getInputStream())); 
				ps 
				= new PrintStream(s.getOutputStream());
				
				System.out.println("\nEnviando para o cliente: " + str1);
				ps.println( str1.substring(0,3) ); 
			} 

			// close connection 
			ps.close(); 
			br.close(); 
			kb.close(); 
			ss.close(); 
			s.close(); 

			// terminate application 
			System.exit(0); 

		} // end of while 
	} 
} 
