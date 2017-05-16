package controller;

import models.*;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    private static final String db_url = "jdbc:postgresql://localhost:5432/WatchneighborsDB";
    private Connection connection;

    public synchronized boolean connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(db_url, "test_login", "test");
            System.out.println("connected to database WachneighborsDB");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection != null;
    }

    public synchronized boolean insertUserIntoDB(User user) {
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_USER_QUERY);
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(5, user.getDistrict().getName());
            preparedStatement.setString(6, user.getEmail());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        }
        return result != 0;
    }

    public synchronized boolean updateUser(User user) {
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getDistrict().getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUserID());
            result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            result = 0;
        }
        return (result != 0);

    }

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

    public synchronized boolean insertReportIntoDB(Report report) {

        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_REPORT_QUERY);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.setString(2, report.getState());
            preparedStatement.setString(3, report.getOutcome());
            preparedStatement.setDate(4, java.sql.Date.valueOf(report.getTimestamp()));
            preparedStatement.setString(5, report.getOwnerUserId());
            preparedStatement.setString(6, report.getChargedUserId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        }
        return (result != 0);
    }

    public synchronized boolean updateReport(Report report) {
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_REPORT_QUERY);
            preparedStatement.setString(1, report.getState());
            preparedStatement.setString(2, report.getOutcome());
            preparedStatement.setDate(3, java.sql.Date.valueOf(report.getTimestamp()));
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = 0;
        }
        return result != 0;
    }

    public synchronized ArrayList<Report> getAllReport() {
        ArrayList<Report> lsReport = new ArrayList<Report>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ALL_REPORT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report report = new Report(
                        resultSet.getInt("id"),
                        Report.STATE.valueOf(resultSet.getString("stato")),
                        resultSet.getString("description"),
                        resultSet.getString("outcome"),
                        resultSet.getDate("timestamp").toString(),
                        resultSet.getString("ownerUser"),
                        resultSet.getString("charedUser"),
                        resultSet.getString("street")
                );

                lsReport.add(report);

            }
            return lsReport;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() throws SQLException {
        System.out.println("Disconneted from database");
        connection.close();
    }

}
