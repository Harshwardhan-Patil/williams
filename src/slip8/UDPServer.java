package slip8;

import java.net.*;
public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876); // Create socket on port 9876
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("Server is running... Waiting for messages...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket); // Receive packet

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedMessage);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String responseMessage = "Hello Client, Message Received!";
                sendData = responseMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket); // Send response to client
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
