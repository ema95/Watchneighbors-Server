package controller;

public class Queries {
    /*
    SQL Statement used to insert arbitrary data
     */
    public static final String INSERT_USER_QUERY = "INSERT INTO utente VALUES(?,?,?,?,?,?)";
    public static final String UPDATE_USER_QUERY = "UPDATE utente SET quartiere = ?, email = ? WHERE userid = ?";
    public static final String DELETE_USER_QUERY = "DELETE FROM utente WHERE userid = ?";

    public static final String INSERT_REPORT_QUERY = "INSERT INTO segnalazione VALUES(?,?,?,?,?,?)";
    public static final String UPDATE_REPORT_QUERY = "UPDATE segnalazione SET stato= ?, esito= ?, timestamp = ? WHERE id = ?";

    public static final String GET_ALL_REPORT_QUERY = "SELECT * FROM segnalazione";

    public static final String LOGIN_QUERY = "SELECT * FROM utente WHERE userid = ? AND password = ?";

}
