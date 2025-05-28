package pl.wsti.edu.no_7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(int port) {
        try (
            ServerSocket server = new ServerSocket(port)
        ) {
            while (true) {
                Socket connection = server.accept();
                Thread thread = new Thread(new Player(connection));

                thread.start();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}