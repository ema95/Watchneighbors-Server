package models;
import java.io.Serializable;

public class Report implements Serializable {

    public enum STATE {OPEN, CLOSED, NOT_RETREIVED};
    private int id;
    private STATE state;
    private String description;// to add in the db table
    private String outcome;
    private String timestamp;
    private String ownerUserId;
    private String chargedUserId;
    private String street; // to add in the db table
    private double latitude;
    private double longitude;

    public Report(int id, STATE state, String outcome,String description, String timestamp, String ownerUserId, String chargedUserId,String street) {
        this.id = id;
        this.state = state;
        this.description = description;
        this.outcome = outcome;
        this.timestamp = timestamp;
        this.ownerUserId = ownerUserId;
        this.chargedUserId = chargedUserId;
        this.street= street;
    }

    public int getId() { return id; }

    public String getState() { return state.toString(); }

    public String getOutcome() { return outcome; }

    public String getTimestamp() { return timestamp; }

    public String getOwnerUserId() { return ownerUserId; }

    public String getChargedUserId() { return chargedUserId; }

    public String getDescription() { return description; }

    public String getStreet() { return street; }
}
