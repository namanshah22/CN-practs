import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 12346;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server on " + host + ":" + port);
            OutputStream out = socket.getOutputStream();
            PrintWriter output = new PrintWriter(out, true);
            InputStream in = socket.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            while (true) {
                System.out.println("Select a contestant from the given options");
                String vote = System.console().readLine();
                System.out.println("Thanks for voting");
                output.println(vote);
                String response = input.readLine();
                System.out.println(response);
                break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

