import java.net.*;

public class UDPClient {
    private static final int SERVER_PORT = 5000;
    private static final String SERVER_IP = "localhost";

    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

        System.out.println("Welcome to the voting system.");
        System.out.println("Enter the name of your candidate or 'exit' to stop voting.");

        while (true) {
            byte[] sendData = new byte[1024];

            String candidateName = System.console().readLine();

            if (candidateName.equalsIgnoreCase("exit")) {
                break;
            }

            sendData = candidateName.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);

            clientSocket.send(sendPacket);
        }

        clientSocket.close();
    }
}
