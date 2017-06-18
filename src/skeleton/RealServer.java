package skeleton;

import models.Report;
import models.User;
import models.Log;
import controller.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class RealServer implements ServerInterface {
    private Controller controller;

    public RealServer(Controller controller) {
        this.controller = controller;
    }

    /**
     * @param user
     * @return
     * @throws IOException
     */
    @Override
    public int createUser(User user) throws IOException {
        System.out.println("entered createUser method of Real Server");
        boolean result = false;
        if (!controller.connect()) {
            System.out.println("Connection error");
            return 0;
        }
        try {
            if (controller.checkAlreadyExistingMail(user.getEmail())) {
                System.out.println("Duplicate mail: user can't be inserted");
                return 2;
            }

            result = controller.insertUserIntoDB(user);
            controller.close();
        } catch (Exception e) {
            System.out.println("Error during creation");
            return 3;
        }
        if (result) {
            String message = "User Created";
            createLogWithoutReport(user, message);
            return 1;
        }
        return 0;
    }

    /**
     * @param user
     * @return
     * @throws IOException
     */
    @Override
    public int deleteUser(User user) throws IOException {
        System.out.println("entered deleteUser method of Real Server");
        boolean result = false;
        if (!controller.connect()) {
            System.out.println("Connection error");
            return 0;
        }
        try {
            result = controller.deleteUser(user);
            controller.close();
        } catch (SQLException e) {
            System.out.println("Error during deleting");
        }

        return result ? 1 : 0;
    }

    /**
     * @param user
     * @return
     * @throws IOException
     */
    @Override
    public int updateUser(User user) throws IOException {

        boolean result = false;
        if (!controller.connect())
            System.out.println("Connection error");
        if(controller.checkAlreadyExistingMail(user.getEmail())){
            System.out.println("Duplicate mail: user can't be updated");
            return 2;
        }
        try {
            result = controller.updateUser(user);
            String message = "Updated user: " + user.getUserID();

            controller.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            String message = "user Updated";
            createLogWithoutReport(user, message);
            return 1;
        }
        return 0;
    }

    /**
     * @param user
     * @param password
     * @return
     * @throws IOException
     */
    @Override
    public User login(String user, String password) throws IOException {
        User resultUser;
        if (!controller.connect())
            System.out.println("Connection error");
        try {
            resultUser = controller.login(user, password);
        } catch (Exception e) {
            e.printStackTrace();
            resultUser = null;
        }
        return resultUser;
    }

    /**
     * @param report
     * @return
     * @throws IOException
     */
    @Override
    public int createReport(Report report) throws IOException {
        boolean result;
        if (!controller.connect()) {
            System.out.println("Connection error");
        }
        try {
            result = controller.insertReportIntoDB(report);
            String message = "Inserted report by: " + report.getOwnerUser() + "at " + report.getTimestamp();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Report non inserted");
            result = false;
        }
        return result ? 1 : 0;
    }

    /**
     * @param report
     * @return
     * @throws IOException
     */
    @Override
    public int updateReport(Report report) throws IOException {
        boolean result;
        try {
            if (!controller.connect())
                System.out.println("Connection error");
            result = controller.updateReport(report);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        if (result) {
            String message = "report Updated";
            createLog(report.getChargedUser(), report, message);
            return 1;
        }
        return 0;
    }

    /**
     * @throws IOException
     */
    @Override
    public void close() throws IOException {

    }

    /**
     * @return return the list containing all the OPEN report
     * @throws IOException
     */
    @Override
    public ArrayList<Report> getAllReport() throws IOException {
        ArrayList<Report> lsResult;
        try {
            if (!controller.connect()) {
                System.out.println("Connection error");
            }
            lsResult = controller.getAllReport();
        } catch (Exception e) {
            e.printStackTrace();
            lsResult = null;
        }
        return lsResult;
    }

    public void createLog(User user, Report report, String message) {
        controller.connect();
        User logUser = controller.retrieveUserByIdFromDb(user.getUserID());
        Report logReport = controller.retrieveReportByIdFromDb(report.getId());
        Log log = new Log(logUser, logReport, message);
        controller.insertLog(log);
        try {
            controller.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createLogWithoutReport(User user, String message) {
        controller.connect();
        User logUser = controller.retrieveUserByIdFromDb(user.getUserID());
        Log log = new Log(logUser, null, message);
        controller.insertLogWithoutReport(log);
        try {
            controller.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
