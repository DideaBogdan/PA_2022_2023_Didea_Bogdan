import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            boolean client = true;
            String raspuns;
            while (client == true) {

                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if (request.equals("stop")) {
                    raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    socket.close();
                    client = false;
                }
                if (request.equals("create game")){
                    Board board = new Board();
                    raspuns = "Game created \n" + board.toString();
                    out.print(raspuns);
                    out.flush();
                }
            }
            if(client == false){
                System.out.println("Thread stopped");
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}

