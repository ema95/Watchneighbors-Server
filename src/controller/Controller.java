package controller;
import utilities.*;
import java.sql.*;

public class Controller {
    private static final String db_url="jdbc:postgresql://localhost:5432/WatchneighborsDB";
    private Connection connection;
    public boolean connect(){
        Connection c=null;
        try{
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection(db_url,"test_login","test");
            System.out.println("connected to database WachneighborsDB");
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection==null ? false : true ;
    }

    public boolean createUser(User user) throws SQLException{
        PreparedStatement preparedStatement=connection.prepareStatement(Queries.INSERT_USER_QUERY);
        user.prepareStatement(preparedStatement);
        int result=preparedStatement.executeUpdate();
        return result==1 ? true : false;
    }
    public boolean deleteUser(){
        return true;
    }
    public boolean createReport(){
        return true;
    }
    public void close() throws SQLException {
        System.out.println("Disconneted from database");
        connection.close();}
}
