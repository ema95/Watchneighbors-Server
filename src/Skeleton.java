import Utility.User;
import interfaces.IServer;

import java.util.List;

/**
 * Created by gecchma1 on 18/04/2017.
 */
public class Skeleton implements IServer, Runnable {



    @Override
    public void run() {

    }


    @Override
    public int registrazione(User user) {
        return 0;
    }

    @Override
    public void Login() {

    }

    @Override
    public List<Void> getSegnalazione() {
        return null;
    }

    @Override
    public int update(Void utente) {
        return 0;
    }

    @Override
    public int eliminaUser() {
        return 0;
    }

    @Override
    public int updateSegnalazioni(List<Void> list) {
        return 0;
    }

    @Override
    public int updateSegnalzione(Void segnalzione) {
        return 0;
    }


}
