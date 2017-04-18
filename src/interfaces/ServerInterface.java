package interfaces;

import Utility.User;

import java.util.List;

/**
 * Created by gecchma1 on 11/04/2017.
 */
public interface ServerInterface {

    public int registrazione(User user);
    public void Login();
    public List<Void> getSegnalazione();
    public int update(Void utente);
    public int eliminaUser();
    public int updateSegnalazioni(List<Void> list);
    public int updateSegnalzione(Void segnalzione);

}
