package Networking;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server waiting...");

            Socket socket = server.accept();
            System.out.println("Client connected!");


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 4: Input from server user
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String messageFromClient, messageToClient;

            while (true) {
                messageFromClient = in.readLine();  // receive message
                if (messageFromClient.equalsIgnoreCase("exit")) break;
                System.out.println("Client: " + messageFromClient);

                System.out.print("Server: ");
                messageToClient = console.readLine();  // reply
                out.println(messageToClient);
            }

            // Step 5: Close everything
            socket.close();
            server.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
