import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        boolean server = true;
        try (
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (
                    new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            while(server == true){
                BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
                String request = buffReader.readLine();
                if(request.equals("exit")){
                    System.out.println("Exiting now...");
                    return;
                }
                out.println(request);
                // Wait the response from the server ("Hello World!")
                String response = in.readLine ();
                System.out.println(response);
                if(response.equals("Server stopped")){
                    server = false;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

