package skeleton;

import utilities.Report;
import utilities.User;
import controller.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


public class RealServer implements ServerInterface {
    private Controller controller;
    public RealServer(){
        controller=new Controller();
    }

    @Override
    public int createUser(User user) throws IOException{
        boolean result=false;
        boolean connectionStatus;
        connectionStatus=controller.connect();
        //check connection status
        if(!connectionStatus)
            return 0;
        try{
            result=controller.createUser(user);
            controller.close();
        }catch(SQLException e){
            System.out.println("Error during creation");
        }
        return result == true ? 1 : 0 ;
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
    public int createReport(Report report) throws IOException {
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
