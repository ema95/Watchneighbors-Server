package utilities;
import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {
    private int id;
    private String state;
    private String outcome;
    private Date timestamp;
    private User ownerUser;
    private User chargedUser;

    public Report(int id, String state, String outcome, Date timestamp, User ownerUser, User chargedUser) {
        this.id = id;
        this.state = state;
        this.outcome = outcome;
        this.timestamp = timestamp;
        this.ownerUser = ownerUser;
        this.chargedUser = chargedUser;
    }

    public int getId() { return id; }

    public String getState() { return state; }

    public String getOutcome() { return outcome; }

    public Date getTimestamp() { return timestamp; }

    public User getOwnerUser() { return ownerUser; }

    public User getChargedUser() { return chargedUser; }
}
