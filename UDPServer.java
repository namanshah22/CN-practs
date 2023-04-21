import java.net.*;
import java.util.HashMap;

public class UDPServer {
    private static final int MAX_PACKET_SIZE = 1024;
    private static final int SERVER_PORT = 5000;
    private static HashMap<String, Integer> candidates = new HashMap<>();

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);

        System.out.println("Server is running on port " + SERVER_PORT);

        byte[] receiveData = new byte[MAX_PACKET_SIZE];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, MAX_PACKET_SIZE);

        while (true) {
            serverSocket.receive(receivePacket);
            String candidateName = new String(receivePacket.getData()).trim();

            int currentVotes = candidates.getOrDefault(candidateName, 0);
            candidates.put(candidateName, currentVotes + 1);

            System.out.println(candidateName + " received a vote from " + receivePacket.getAddress().getHostAddress());
        }
    }
}

