package slip7;

import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) {
        int port = 1234;  
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            Thread sendThread = new Thread(new MessageSender(clientSocket));
            Thread receiveThread = new Thread(new MessageReceiver(clientSocket));
            sendThread.start();
            receiveThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class MessageSender1 implements Runnable {
    private Socket socket;
    public MessageSender1(Socket socket) {
        this.socket = socket;
    }
   @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = consoleReader.readLine()) != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
