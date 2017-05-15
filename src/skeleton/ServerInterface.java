package skeleton;

import models.*;
import java.io.IOException;
import java.util.ArrayList;

public interface ServerInterface {
    public int createUser(User user) throws IOException;
    public int deleteUser(User user) throws IOException;
    public int updateUser(User user) throws IOException;
    public User login(String user, String password) throws IOException;
    public int createReport(Report report) throws IOException;
    public int updateReport(Report report) throws IOException;
    public void close() throws IOException;
    public ArrayList<Report> getAllReport() throws IOException;
    static final int PORT=8080;
}
