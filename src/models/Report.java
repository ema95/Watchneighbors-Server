package models;
import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

    public enum STATE {OPEN, CLOSED, NOT_RETREIVED};
    private int id;
    private STATE state;
    private String outcome;
    private String timestamp;
    private User ownerUser;
    private User chargedUser;

    public Report(int id,STATE state, String outcome, String timestamp, User ownerUser, User chargedUser) {
        this.id = id;
        this.state = state;
        this.outcome = outcome;
        this.timestamp = timestamp;
        this.ownerUser = ownerUser;
        this.chargedUser = chargedUser;
    }

    public int getId() { return id; }

    public String getState() { return state.toString(); }

    public String getOutcome() { return outcome; }

    public String getTimestamp() { return timestamp; }

    public User getOwnerUser() { return ownerUser; }

    public User getChargedUser() { return chargedUser; }
}
