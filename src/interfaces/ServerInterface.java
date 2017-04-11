package interfaces;

import utilities.User;

import java.util.List;

/**
 * Created by gecchma1 on 11/04/2017.
 */
public interface ServerInterface {
    public int registration(User user);
    public User Login();
    public List<String> getNotifications();
    public int update(User user);
    public int deleteUser();
    public int updateReportings(List<String> list);
    public int updateReporting(String reporting);

}
