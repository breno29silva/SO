package br.ufc.questao4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class DateClient {
    public static void main(String[] args) throws IOException {
        InputStream in;
        BufferedReader bin;

        String serverMessage = null;
        Scanner reader = new Scanner(System.in);
        try (Socket sock = new Socket("127.0.0.1", 6013)) {
            PrintWriter printWriter = new PrintWriter(sock.getOutputStream(), true);
            while (true) {
                System.out.println("Type the identifier: ");
                String id = reader.next();
                System.out.println("Type the operation:\n" +
                        "1. Send message\n" +
                        "2. Receive message");
                String op = reader.next();
                switch (op) {
                    case "1":
                        System.out.println("Type the message: ");
                        String msg = reader.next();

                        System.out.println("Receiver Id: ");
                        String destinyId = reader.next();

                        serverMessage = op + ":" + msg + ":" + id + ":" + destinyId;
                        break;
                    case "2":
                        serverMessage = op + ":" + id;
                }
                printWriter.println(serverMessage);
                in = sock.getInputStream();
                bin = new BufferedReader(new InputStreamReader(in));

                String line;
                if (Integer.parseInt(op) == 2) {
                    while ((line = bin.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
