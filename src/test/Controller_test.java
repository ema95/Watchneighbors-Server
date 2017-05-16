package test;
import controller.Controller;
import junit.framework.*;
import models.District;
import models.Report;
import models.User;
import org.dbunit.*;
import org.dbunit.database.IDatabaseConnection;
import org.slf4j.*;

import java.sql.Date;
import java.sql.SQLException;

public class Controller_test extends TestCase {
    protected Controller controller;
    protected IDatabaseTester databaseTester;
    User userXXX;


    protected void setUp(){
        userXXX =new User("ema","Emanuele","Calzavara","1995-09-26",new District("Quartiere 1"),"emanuele@gmail.it");

        controller = new Controller();
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:hsqldb:sample" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
    }

    @org.junit.Test
    public void testConnection() {
    assert controller.connect();

    }

    @org.junit.Test
    public void testInsertUserIntoDB(){
        User user=new User("ema2","Emanuele","Calzavara","1995-09-26",new District("Quartiere 1"),"ema@gmail.it");
        controller.connect();
        assert controller.insertUserIntoDB(user);
    }

    @org.junit.Test
    public void testUpdateUser(){
        User user=new User("ema","Emanuele","Calzavara","1995-09-26",new District("Quartiere 1"),"emanuele@gmail.it");
        controller.connect();
        assert controller.updateUser(user);
    }
    @org.junit.Test
    public void testDeleteUser(){
        User user=new User("ema","Emanuele","Calzavara","1995-09-26",new District("Quartiere 1"),"emanuele@gmail.it");
        controller.connect();
        assert controller.deleteUser(user);
    }

//    @org.junit.Test
//    public void testInsertReportIntoDB(){
//        Report report = new Report(1, Report.STATE.NOT_RETREIVED, null, "2013-12-13", userXXX, userXXX );
//        controller.connect();
//        assert controller.insertReportIntoDB(report);
//    }

}
