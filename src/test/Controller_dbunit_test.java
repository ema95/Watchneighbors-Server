package test;
import controller.Controller;
import junit.framework.*;
import models.District;
import models.Report;
import models.User;
import org.dbunit.*;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.slf4j.*;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
public class Controller_dbunit_test extends TestCase{

    @org.junit.Test
    protected void insertTest(){
        try{
            IDatabaseTester databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/WatchneighborsDB", "test_login", "test");
            IDataSet actualSet= databaseTester.getDataSet();
            ITable actualTable= actualSet.getTable("utente");



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
