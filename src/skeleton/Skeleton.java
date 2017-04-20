package skeleton;

import utilities.Report;
import utilities.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Skeleton extends Thread implements ServerInterface {
    private Socket socket;
    private ServerInterface server;
    DataInputStream in;
    DataOutputStream out;

    public Skeleton(Socket socket) throws IOException {
        this.socket=socket;
        server=new RealServer();
        in=new DataInputStream(socket.getInputStream());
        out=new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public int createUser(User user) throws IOException {
        return 0;
    }

    @Override
    public int deleteUser(User user) throws IOException {
        return 0;
    }

    @Override
    public int updateUser(User user) throws IOException {
        return 0;
    }

    @Override
    public User login(String usr, String psw) throws IOException {
        return null;
    }

    @Override
    public int createReport(Report r) throws IOException {
        return 0;
    }

    @Override
    public int updateReport(Report r) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
