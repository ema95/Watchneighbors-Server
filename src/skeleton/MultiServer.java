package skeleton;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static int PORT=8080;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(PORT);
        System.out.println("Server started");
        while(true){
            try{
                Socket socket=serverSocket.accept();
                Skeleton server=new Skeleton(socket);
                server.start();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
