package models;

import java.io.Serializable;

/**
 * Class used to manipulate report objects
 */
public class Report implements Serializable {

    public enum STATE {OPEN, CLOSED, CHARGED}

    private int id;

    private STATE state;

    private String description;// to add in the db table
    private String outcome;
    private String timestamp;
    private User ownerUser;
    private User chargedUser;
    private double latitude;
    private double longitude;

    public Report(int id, STATE state, String outcome, String description, String timestamp, User ownerUser, User chargedUser, double latitude, double longitude) {
        this.id = id;
        this.state = state;
        this.description = description;
        this.outcome = outcome;
        this.timestamp = timestamp;
        this.ownerUser = ownerUser;
        this.chargedUser = chargedUser;
        this.latitude = latitude;
        this.longitude = longitude;

    }


    public int getId() {
        return id;
    }

    public String getState() {
        return state.toString();
    }

    public String getOutcome() {
        return outcome;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public User getChargedUser() {
        return chargedUser;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setState(STATE state) {
        this.state = state;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setChargedUser(User chargedUser) {
        this.chargedUser = chargedUser;
    }

    @Override
    public String toString() {
        return "id: " + id + ", Stato: " + state + ", Descrizione: " + description + ", Giorno e ora: " + timestamp + ", Owner: " + ownerUser.getUserID() + ", Utente incaricato: " + (chargedUser.getUserID() != null ? chargedUser.getUserID()     : "not_assigned") + ", Latitutine: " + latitude + ", Longitudine: " + longitude;
    }
}
