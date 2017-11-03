import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        String hostname = "www.perdu.com";
        int hostport = 80;
        Socket ClientSocket = null;

        try {
            ClientSocket = new Socket(hostname, hostport);
            if (ClientSocket != null) {
                System.out.println("Client connected to " + hostname);
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
                DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream());
                outToServer.writeBytes("GET / HTTP/1.1\r\n\r\n");

                String response;
                while((response = inFromServer.readLine()) != null) {
                    System.out.println(response);
                }
            }

            ClientSocket.close();
        } catch (IOException var7) {
            System.out.println("no connected to the socket!");
            var7.printStackTrace();
        }

    }
}
