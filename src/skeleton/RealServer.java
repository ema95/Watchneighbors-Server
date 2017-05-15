package skeleton;

import models.Report;
import models.User;
import controller.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class RealServer implements ServerInterface {
    private Controller controller;
    public RealServer(){
        controller=new Controller();
    }

    @Override
    public int createUser(User user) throws IOException{
        boolean result=false;
        if(!controller.connect()) {
            System.out.println("Connection error");
            return 0;
        }
        try{
            result=controller.insertUserIntoDB(user);
            controller.close();
        }catch(SQLException e){
            System.out.println("Error during creation");
        }
        return result ? 1 : 0 ;
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
    @Override
    public ArrayList<Report> getAllReport() throws IOException{
        return null;
    }
}
