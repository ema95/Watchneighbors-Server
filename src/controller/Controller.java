package controller;
import models.*;
import java.sql.*;

public class Controller {
    private static final String db_url="jdbc:postgresql://localhost:5432/WatchneighborsDB";

    private Connection connection;
    public boolean connect(){
        Connection connection=null;
        try{
            Class.forName("org.postgresql.Driver");
            this.connection =DriverManager.getConnection(db_url,"test_login","test");
            System.out.println("connected to database WachneighborsDB");
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.connection != null;
    }

    public synchronized boolean insertUserIntoDB(User user){
        int result;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(Queries.INSERT_USER_QUERY);
            preparedStatement.setString(1,user.getUserID());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurname());
            preparedStatement.setDate(4,java.sql.Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(5,user.getDistrict().getName());
            preparedStatement.setString(6,user.getEmail());
            result=preparedStatement.executeUpdate();
        }catch(SQLException e){
            result=0;
        }
        return result != 0;
    }
    public boolean updateUser(User user) {
        int result;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(Queries.UPDATE_USER_QUERY);
            preparedStatement.setString(1,user.getDistrict().getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getUserID());
            result=preparedStatement.executeUpdate();
            System.out.println(result);
        }catch(SQLException e){
            result =0;
        }
        return (result!=0);

    }
    public boolean deleteUser(User user){
        int result;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(Queries.DELETE_USER_QUERY);
            preparedStatement.setString(1,user.getUserID());
            result=preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            result =0;
        }
        return result!=0;
    }
    public boolean insertReportIntoDB(Report report){

        int result;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(Queries.INSERT_REPORT_QUERY);
            preparedStatement.setInt(1,report.getId());
            preparedStatement.setString(2,report.getState());
            preparedStatement.setString(3,report.getOutcome());
            preparedStatement.setDate(4,java.sql.Date.valueOf(report.getTimestamp()));
            preparedStatement.setString(5,report.getOwnerUser().getUserID());
            preparedStatement.setString(6,report.getChargedUser().getUserID());
            result=preparedStatement.executeUpdate();
        }catch(SQLException e){
            result=0;
        }
        return result != 0;
    }
    public boolean updateReport(Report report){
        return false;
    }
    public boolean getAllReport(){
        return false;
    }
    public void close() throws SQLException {
        System.out.println("Disconneted from database");
        connection.close();}

}
