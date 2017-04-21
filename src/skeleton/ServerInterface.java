package skeleton;

import utilities.*;
import java.io.IOException;

public interface ServerInterface {
    public User createUser() throws IOException;
    public int deleteUser(User user) throws IOException;
    public int updateUser(User user) throws IOException;
    public User login(String usr, String psw) throws IOException;
    public Report createReport() throws IOException;
    public int updateReport(Report r) throws IOException;
    public void close() throws IOException;
    static final int PORT=8080;
}