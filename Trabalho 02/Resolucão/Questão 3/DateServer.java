package main;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class DateServer
{
	public static void main(String[] args) throws IOException {
		Socket client = null;
		ServerSocket sock = null;
		InputStream in = null;
		BufferedReader bin = null;

		try {
			sock = new ServerSocket(6013);
			while (true) {
				client = sock.accept();		
				Scanner entrada = new Scanner(client.getInputStream());
	            System.out.println(entrada.nextLine().split(":"));	           				
				System.out.println("server = " + sock);
				System.out.println("client = " + client);					
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				pout.println(new java.util.Date().toString());
				pout.close();
				client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
		finally {
			if (sock != null)
				sock.close();
			if (client != null)
				client.close();
		}
	}
}
