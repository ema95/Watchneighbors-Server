package skeleton;

import controller.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class MultiServer {
    public static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started");
        Controller controller = Controller.getSingletonController();

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Connection Accepted" + socket);
                Skeleton skeleton = new Skeleton(socket, controller);
                skeleton.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
