package main;

import java.net.*;
import java.io.*;

public class DateClient {
	public static void main(String[] args) throws IOException, InterruptedException {
		InputStream in = null;
		BufferedReader bin = null;
		Socket sock = null;

		String equacao = "+:2:4";

		try {
			sock = new Socket("127.0.0.1", 6013);
			PrintWriter pout = new PrintWriter(sock.getOutputStream());
			pout.println(equacao);
			pout.flush();

			in = sock.getInputStream();
			bin = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = bin.readLine()) != null)
				System.out.println(line);

		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			sock.close();
		}
	}
}
