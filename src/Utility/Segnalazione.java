package Utility;

import java.util.Date;

/**
 * Created by Davide on 18/04/2017.
 */
public class Segnalazione
{
        private int id;
        private String stato;
        private String esito;
        private Date timestamp;
        private User utente_creatore;
        private User utente_incaricato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUtente_creatore() {
        return utente_creatore;
    }

    public void setUtente_creatore(User utente_creatore) {
        this.utente_creatore = utente_creatore;
    }

    public User getUtente_incaricato() {
        return utente_incaricato;
    }

    public void setUtente_incaricato(User utente_incaricato) {
        this.utente_incaricato = utente_incaricato;
    }

    public Segnalazione(int id, String stato, String esito, Date timestamp, User utente_creatore, User utente_incaricato)
    {
        this.id = id;
        this.stato = stato;
        this.esito = esito;
        this.timestamp = timestamp;
        this.utente_creatore = utente_creatore;
        this.utente_incaricato = utente_incaricato;
    }
}
