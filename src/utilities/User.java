
package Utility;

import java.util.Date;

/**
 * Created by emanuele on 11.04.17.
 */
public class User
{

    private int userID;
    private String nome;
    private String cognome;
    private Date data_nascita;
    private String quartiere;

    public User(int userID, String nome, String cognome, Date data_nascita, String quartiere)
    {
        this.userID = userID;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.quartiere = quartiere;
    }

    public int getUserID() {
        return userID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public String getQuartiere() {
        return quartiere;
    }



}
