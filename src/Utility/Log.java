package Utility;

/**
 * Created by Davide on 18/04/2017.
 */
public class Log {

    private int id;
    private int userID;

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getSegnalazione() {
        return segnalazione;
    }

    public String getTipo() {
        return tipo;
    }

    private String segnalazione;
    private String tipo;

    public Log(int id, int userID, String segnalazione, String tipo)
    {
        this.id = id;
        this.userID = userID;
        this.segnalazione = segnalazione;
        this.tipo = tipo;
    }


}
