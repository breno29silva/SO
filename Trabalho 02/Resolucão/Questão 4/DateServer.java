package br.ufc.questao4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DateServer {
    public static void main(String[] args) throws IOException {
        Socket client = null;
        ServerSocket sock = null;
        BufferedReader bin;
        InputStream in;
        ArrayList<String> mailbox = new ArrayList<>();
        String line;

        try {
            sock = new ServerSocket(6013);

            while (true) {
                client = sock.accept();
                System.out.println("[server] " + sock);
                System.out.println("[client] " + client);
                in = client.getInputStream();
                bin = new BufferedReader(new InputStreamReader(in));
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                while ((line = bin.readLine()) != null) {
                    verifyMessage(line, mailbox, pout);
                }
                pout.close();
                client.close();
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        } finally {
            if (sock != null)
                sock.close();
            if (client != null)
                client.close();
        }
    }

    public static void verifyMessage(String msg, ArrayList<String> mailbox, PrintWriter printWriter) {
        String[] strings = msg.split(":");
        switch (strings[0]) {
            case "1":
                mailbox.add(msg);
                printWriter.println("Message received.");
                break;
            case "2":
                printWriter.println("Inbox: ");
                searchMessage(strings[1], mailbox, printWriter);
                break;
            default:
                printWriter.println("Invalid");
                break;
        }
    }

    public static void searchMessage(String id, ArrayList<String> mailbox, PrintWriter pout) {
        String[] strings;
        int i = 0;
        while (i < mailbox.size()) {
            strings = mailbox.get(i).split(":");
            if (Integer.parseInt(strings[3]) == Integer.parseInt(id)) {
                pout.println(strings[1] + ". \n" +
                        "Send by: " + strings[2]);
            }
            i++;
        }
        String n = null;
        pout.println(n);
    }

}
