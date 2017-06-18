package skeleton;

import controller.Controller;
import models.Message;
import models.Report;
import models.User;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Class used to communicate with a client
 */
public class Skeleton extends Thread implements ServerInterface {
    private Socket socket;
    private ServerInterface realServer;
    private String operation;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    /*
     code used to communicate the result of an operation
     1 if the operation is successful, 0 otherwise
     */
    private int resultCode;

    public void run() {
        try {
            try {
                while (true) {

                    Object receivedObject = objectInputStream.readObject();

                    if (receivedObject instanceof String) {
                        operation = (String) receivedObject;
                        if (receivedObject.equals(Message.CREATE_USER)) {
                            System.out.println("Receveid message: " + Message.CREATE_USER);
                            User user = (User) objectInputStream.readObject();
                            resultCode = realServer.createUser(user);
                            objectOutputStream.writeObject(resultCode);
                            objectOutputStream.flush();

                        } else if (receivedObject.equals(Message.UPDATE_USER)) {

                            User user = (User) objectInputStream.readObject();
                            resultCode = realServer.updateUser(user);
                            objectOutputStream.writeObject(resultCode);

                        } else if (receivedObject.equals(Message.DELETE_USER)) {

                            User user = (User) objectInputStream.readObject();
                            resultCode = realServer.deleteUser(user);
                            objectOutputStream.writeObject(resultCode);

                        } else if (receivedObject.equals(Message.CREATE_REPORT)) {

                            Report report = (Report) objectInputStream.readObject();
                            resultCode = realServer.createReport(report);
                            objectOutputStream.writeObject(resultCode);

                        } else if (receivedObject.equals(Message.UPDATE_REPORT)) {
                            System.out.println("ricevuto messaggio update report");
                            Report report = (Report) objectInputStream.readObject();
                            resultCode=realServer.updateReport(report);
                            objectOutputStream.writeObject(resultCode);

                        } else if (receivedObject.equals(Message.LOGIN)) {

                            String logUser = (String) objectInputStream.readObject();
                            String logPassword = (String) objectInputStream.readObject();
                            User tempUser = realServer.login(logUser, logPassword);
                            objectOutputStream.writeObject(tempUser);

                        } else if (receivedObject.equals(Message.SELECT_ALL_REPORT)) {

                            ArrayList<Report> allReport = new ArrayList<>();
                            allReport = realServer.getAllReport();
                            objectOutputStream.writeObject(allReport);


                        } else if (receivedObject.equals(Message.CLOSE)) {
                            break;
                        }
                    }
                }
            } finally {
                this.close();
            }
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Skeleton(Socket socket, Controller controller) throws IOException {
        this.socket = socket;
        realServer = new RealServer(controller);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }


    @Override
    public int createUser(User user) throws IOException {
        int resultCode = realServer.createUser(user);
        objectOutputStream.writeObject(resultCode);
        objectOutputStream.flush();
        return resultCode;
    }


    @Override
    public int deleteUser(User user) throws IOException {
        return 0;
    }

    @Override
    public int updateUser(User user) throws IOException {
        System.out.println("Aggiorna User");
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
    public ArrayList<Report> getAllReport() throws IOException {
        return null;
    }

    @Override
    public void close() throws IOException {
        realServer.close();
        System.out.println("closing");
        // objectOutputStream.close();
        // objectInputStream.close();
        socket.close();
    }
}
