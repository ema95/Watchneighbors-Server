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
            System.out.println("Error during insertion");
            return false;
        }
        return true;
    }

    public boolean createUser(User user) throws SQLException{
        Statement createUserStatement=connection.createStatement();
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
    public void close() throws SQLException { connection.close();}

}
