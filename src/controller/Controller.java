package controller;

import models.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Controller {
    public  static final String DB_NAME = "watchneighborsdb";
    private static final String db_url = "jdbc:postgresql://localhost:5432/"+DB_NAME;
    private Connection connection;

    private static Controller singletonController = null;

    private Controller() {

    }

    public static Controller getSingletonController() {
        if (singletonController == null)
            singletonController = new Controller();
        return singletonController;
    }

    /**
     *
     * @return
     */
    public synchronized boolean connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(db_url, "test_login", "test");
            System.out.println("connected to database WachneighborsDB");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof SQLException) {
                System.out.println(((SQLException) e).getSQLState());
                e.printStackTrace();
            }

        }
        return this.connection != null;
    }

    /**
     *
     * @param user
     * @return
     */
    public synchronized boolean insertUserIntoDB(User user) {
        System.out.println("entered insertUserIntoDB method of controller");
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_USER_QUERY);
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getDistrict().getName());
            preparedStatement.setDouble(8, user.getLatitude());
            preparedStatement.setDouble(9, user.getLongitude());
            System.out.println("Inserting the user");
            result = preparedStatement.executeUpdate();
            mailSender.mailSender.sendMail(user.getEmail(), user.getUserID(), user.getPassword());

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println("Insertion failed");
            e.printStackTrace();
            result = 0;
        } catch (Exception e) {
            System.out.println("Insertion failed");
            e.printStackTrace();
            result = 0;
        }
        return result != 0;
    }

    /**
     *
     * @param user
     * @return
     */
    public synchronized boolean updateUser(User user) {
        int result;
        try {
            System.out.println("Updating user");
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getDistrict().getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getUserID());
            result = preparedStatement.executeUpdate();
            System.out.println("Update executed");
        } catch (Exception e) {
            result = 0;
        }
        return (result != 0);

    }

    /**
     *
     * @param user The user to delete from the DB.
     * @return true if the "delete" action worked correctly.
     */
    public synchronized boolean deleteUser(User user) {
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_USER_QUERY);
            preparedStatement.setString(1, user.getUserID());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            result = 0;
        }
        return result != 0;
    }

    /**
     *
     * @param user
     * @param password
     * @return The user having corresponding username and password if it exists, null otherwise.
     */
    public synchronized User login(String user, String password) {
        User resultUser = null;
        ResultSet result;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.LOGIN_QUERY);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultUser = new User(
                        result.getString("userid"),
                        result.getString("name"),
                        result.getString("surname"),
                        result.getString("birthdate"),
                        new District(result.getString("district")),
                        result.getString("email"),
                        result.getString("password"),
                        result.getDouble("latitude"),
                        result.getDouble("longitude"));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultUser = null;
        }
        System.out.println("login finished");
        return resultUser;
    }

    /**
     *
     * @param report The report will be inserted in the DB.
     * @return
     */
    public synchronized boolean insertReportIntoDB(Report report) {
        System.out.println("Inserting report");
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_REPORT_QUERY);
            preparedStatement.setString(1, report.getState());
            preparedStatement.setString(2, report.getOutcome());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(report.getTimestamp()));
            preparedStatement.setString(4, report.getOwnerUser().getUserID());
            preparedStatement.setString(5, report.getDescription());
            preparedStatement.setDouble(6, report.getLongitude());
            preparedStatement.setDouble(7, report.getLatitude());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = 0;
        }
        return (result != 0);
    }

    /**
     *
     * @param report The report will be updated in the DB.
     * @return The operation status code.
     */
    public synchronized boolean updateReport(Report report) {
        System.out.println("Entered updateReport method of Controller");
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_REPORT_QUERY);
            preparedStatement.setString(1, report.getState());
            preparedStatement.setString(2, report.getOutcome());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(report.getTimestamp()));
            preparedStatement.setString(4, report.getChargedUser().getUserID());
            preparedStatement.setInt(5,report.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = 0;
        }
        return result != 0;
    }

    /**
     *
     * @return return a list containing all the Report stored in the database.
     */
    public synchronized ArrayList<Report> getAllReport() {
        ArrayList<Report> lsReport = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ALL_REPORT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report report = new Report(
                        resultSet.getInt("id"),
                        Report.STATE.valueOf(resultSet.getString("state")),
                        resultSet.getString("outcome"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("timestamp").toString(),
                        retrieveUserByIdFromDb(resultSet.getString("ownerUser")),
                        retrieveUserByIdFromDb(resultSet.getString("chargedUser")),
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude")
                );

                lsReport.add(report);

            }
            return lsReport;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param log The log will be inserted in the DB.
     */
    public synchronized void insertLogWithoutReport(Log log) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_LOG_QUERY_WITHOUT_REPORT);
            preparedStatement.setTimestamp(1, (new java.sql.Timestamp(new java.util.Date().getTime())));
            preparedStatement.setString(2,log.getLogDescription());
            preparedStatement.setString(3,log.getUser().getUserID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param log The log will be inserted in the DB.
     */
    public synchronized  void insertLog(Log log){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_LOG_QUERY);
            preparedStatement.setTimestamp(1,(new java.sql.Timestamp(new java.util.Date().getTime())));
            preparedStatement.setString(2,log.getLogDescription());
            preparedStatement.setString(3,log.getUser().getUserID());
            preparedStatement.setInt(4,log.getReport().getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param mail check if the mail already exists into the database.
     * @return Return true if the mail already exists.
     */
    public synchronized boolean checkAlreadyExistingMail(String mail) {
        boolean result = false;
        ResultSet set;
        //String query = "SELECT nome FROM utente WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.CHECK_EMAIL_QUERY);
            preparedStatement.setString(1, mail);
            set = preparedStatement.executeQuery();
            int counter = 0;
            while (set.next()) {
                counter++;
                result = true;
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     *
     * @param id The id used to retrieve user from the DB.
     * @return The user wit the id param.
     */
    public User retrieveUserByIdFromDb(String id) {
        User user=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_USER_BY_ID_QUERY);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getString("userid"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        new District(resultSet.getString("district")),
                        resultSet.getString("password"),
                        resultSet.getString("birthdate"),
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;


    }

    /**
     *
     * @param id The id used to retrieve report from the DB.
     * @return The report wit the id param.
     */
    public Report retrieveReportByIdFromDb(int id){
        Report report = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_REPORT_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                report = new Report(
                        resultSet.getInt("id"),
                        Report.STATE.valueOf(resultSet.getString("state")),
                        resultSet.getString("outcome"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("timestamp").toString(),
                        retrieveUserByIdFromDb(resultSet.getString("ownerUser")),
                        retrieveUserByIdFromDb(resultSet.getString("chargedUser")),
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }

    /**
     * Close the connection to the DB.
     * @throws SQLException
     */
    public synchronized void close() throws SQLException {
        System.out.println("Disconneted from database");
        connection.close();
    }

}
