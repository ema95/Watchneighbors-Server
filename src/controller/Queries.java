package controller;

/**
 * This class contains all the query needed to manipulate the database.
 */
public class Queries {

    public static final String INSERT_USER_QUERY = "INSERT INTO myuser VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_USER_QUERY = "UPDATE myuser " +
            "SET district = ?, email = ?, password = ? " +
            "WHERE userid = ?";
    public static final String DELETE_USER_QUERY = "DELETE FROM myuser WHERE userid = ?";

    public static final String INSERT_REPORT_QUERY = "INSERT INTO report (state, outcome, timestamp, ownerUser, description, latitude, longitude) VALUES(?,?,?,?,?,?,?)";
    public static final String UPDATE_REPORT_QUERY = "UPDATE report " +
            "SET state= ?, outcome= ?, timestamp = ?, chargedUser = ? " +
            "WHERE id = ?";

    public static final String GET_ALL_REPORT_QUERY = "SELECT * FROM report";
    public static final String GET_USER_BY_ID_QUERY = "SELECT * FROM myuser WHERE userid = ?";
    public static final String GET_REPORT_BY_ID_QUERY = "SELECT * FROM report WHERE id = ?";

    public static final String LOGIN_QUERY = "SELECT * FROM myuser WHERE userid = ? AND password = ?";

    public static final String INSERT_LOG_QUERY = "INSERT INTO log(timestamp, message, userid, reportid) VALUES(?,?,?,?)";//timestamp + description
    public static final String INSERT_LOG_QUERY_WITHOUT_REPORT = "INSERT INTO log(timestamp, message, userid) VALUES(?,?,?)";//timestamp + description
    public static final String CHECK_EMAIL_QUERY = "SELECT * FROM myuser WHERE email= ?";

}
