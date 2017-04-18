package interfaces;

import Utility.User;

import java.util.List;

/**
 * Created by gecchma1 on 11/04/2017.
 */
public interface ServerInterface {

    public int registrazione(User user);
    public Utente Login();
    public List<Segnalazione> getSegnalazione();
    public int update(Utente utente);
    public int eliminaUser();
    public int updateSegnalazioni(List<Segnalazione> list);
    public int updateSegnalzione(Segnalazione segnalzione);

}
