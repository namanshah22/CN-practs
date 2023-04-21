import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 9999; 
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Voting Server Started on port " + port);
            int candidate1Votes = 0;
            int candidate2Votes = 0;

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostName());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientInput = in.readLine();

                if (clientInput.equalsIgnoreCase("Candidate1")) {
                    candidate1Votes++;
                    out.println("Vote successfully registered for Candidate1");
                } else if (clientInput.equalsIgnoreCase("Candidate2")) {
                    candidate2Votes++;
                    out.println("Vote successfully registered for Candidate2");
                } else if (clientInput.equalsIgnoreCase("Result")) {
                    out.println("Candidate1 Votes: " + candidate1Votes + "\nCandidate2 Votes: " + candidate2Votes);
                } else {
                    out.println("Invalid input. Please try again.");
                }

                in.close();
                out.close();
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
