package skeleton;

import utilities.Report;
import utilities.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class RealServer implements ServerInterface {
    public RealServer(){
        /*
        Eventuali inizializzazioni
         */
    }

    @Override
    public User createUser() throws IOException {
        return null;
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
    public Report createReport() throws IOException {
        return null;
    }

    @Override
    public int updateReport(Report r) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
