package Networking;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args)  throws IOException {
        try{
            Socket socket = new Socket("localhost",5000);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 3: Input from client user
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String messageToServer, messageFromServer;

            while (true) {
                System.out.print("Client: ");
                messageToServer = console.readLine();  // input
                out.println(messageToServer);  // send
                if (messageToServer.equalsIgnoreCase("exit")) break;

                messageFromServer = in.readLine();  // receive reply
                System.out.println("Server: " + messageFromServer);
            }

            // Step 4: Close everything
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


    }
}
