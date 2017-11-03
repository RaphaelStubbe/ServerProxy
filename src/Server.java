import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        short Serverport = 8090;

        try {
            ServerSocket MyServer = new ServerSocket(Serverport);
            System.out.println("test");

            while(true) {
                System.out.println("Server socket open on port " + Serverport);
                Socket connectionsocket = MyServer.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionsocket.getInputStream()));
                new DataOutputStream(connectionsocket.getOutputStream());

                String ClientSentece;
                while((ClientSentece = inFromClient.readLine()) != null) {
                    System.out.println(ClientSentece);
                }
            }
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }
}
