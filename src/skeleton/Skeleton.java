package skeleton;

import models.Message;
import models.Report;
import models.User;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Skeleton extends Thread implements ServerInterface {
    private Socket socket;
    private ServerInterface server;
    private String operation;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    /*
     code used to communicate the result of an operation
     1 if the operation is successful, 0 otherwise
     */
    private int resultCode;

    public void run(){
        while(true){
            try{
                System.out.println("Connection Accepted"+socket);
                Object receivedObject= objectInputStream.readObject();
                if(receivedObject instanceof String){
                    operation=(String) receivedObject;
                    if(receivedObject.equals(Message.CREATE_USER)){
                        System.out.println("Receveid message: "+Message.CREATE_USER);
                        User user= (User)objectInputStream.readObject();
                        resultCode=server.createUser(user);
                        objectOutputStream.writeObject(resultCode);
                        System.out.println("finished inseting user");

                    }else if(receivedObject.equals(Message.UPDATE_USER)){

                        User user= (User)objectInputStream.readObject();
                        resultCode=server.updateUser(user);
                        objectOutputStream.writeObject(resultCode);

                    }else if(receivedObject.equals(Message.DELETE_USER)){

                        User user = (User) objectInputStream.readObject();
                        resultCode= server.deleteUser(user);
                        objectOutputStream.writeObject(resultCode);

                    }else if(receivedObject.equals(Message.CREATE_REPORT)){

                        Report report= (Report)objectInputStream.readObject();
                        resultCode = server.createReport(report);
                        objectOutputStream.writeObject(resultCode);

                    } else if (receivedObject.equals(Message.UPDATE_REPORT)) {

                        Report report = (Report)objectInputStream.readObject();
                        server.updateReport(report);
                        objectOutputStream.writeObject(resultCode);

                    }else if(receivedObject.equals(Message.LOGIN)){

                        User user = (User) objectInputStream.readObject();
                        //resultCode=server.login(user.getUserID(),user.getPassword());

                    }else if(receivedObject.equals(Message.SELECT_ALL_REPORT)){

                        ArrayList<Report> allReport= new ArrayList<Report>();
                        allReport=server.getAllReport();
                        objectOutputStream.writeObject(allReport);


                    }else if(receivedObject.equals(Message.CLOSE)){

                        server.close();
                    }
                }
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public Skeleton(Socket socket) throws IOException {
        this.socket=socket;
        server=new RealServer();
        objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
        objectInputStream =new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public int createUser(User user) throws IOException {
        int resultCode=server.createUser(user);
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
    public ArrayList<Report> getAllReport() throws IOException{
        return null;
    }

    @Override
    public void close() throws IOException {
        server.close();
        objectOutputStream.close();
        objectInputStream.close();
    }
}
