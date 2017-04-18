import Utility.User;
import interfaces.IServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

/**
 * Created by gecchma1 on 18/04/2017.
 */
public class ServerReale extends Skeleton {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(IServer.PORT);

        while(true){



        }

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
