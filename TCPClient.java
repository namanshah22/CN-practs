import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;

        try {
            Socket clientSocket = new Socket(host, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput = "";

            while (!userInput.equalsIgnoreCase("exit")) {
                System.out.println("Please enter your vote (Candidate1 or Candidate2) or enter Result to get vote count:");
                userInput = stdIn.readLine();
                out.println(userInput);

                String serverResponse = in.readLine();
                System.out.println(serverResponse);
            }

            in.close();
            out.close();
            stdIn.close();
            clientSocket.close();

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
