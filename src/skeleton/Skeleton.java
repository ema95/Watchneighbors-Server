package skeleton;

import utilities.Message;
import utilities.Report;
import utilities.User;
import java.io.*;
import java.net.Socket;

public class Skeleton extends Thread implements ServerInterface {
    private Socket socket;
    private ServerInterface server;
    private String operation;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public void run(){
        while(true){
            try{
                System.out.println("Connection Accepted"+socket);
                Object o= objectInputStream.readObject();
                if(o instanceof String){
                    operation=(String) o;
                    if(o.equals(Message.CREATE_USER)){
                        User user=(User) objectInputStream.readObject();
                        server.createUser(user);
                    }else if(o.equals(Message.UPDATE_USER)){

                    }else if(o.equals(Message.DELETE_USER)){

                    }else if(o.equals(Message.CREATE_REPORT)){

                    } else if (o.equals(Message.UPDATE_REPORT)) {

                    }else if(o.equals(Message.LOGIN)){

                    }else if(o.equals(Message.CLOSE)){

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
    public void close() throws IOException {
        server.close();
        objectOutputStream.close();
        objectInputStream.close();
    }
}
