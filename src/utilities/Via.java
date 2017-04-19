package utilities;

/**
 * Created by Davide on 18/04/2017.
 */
public class Via
{

        private String nome;
        private District quartiere;

	public Via(String nome, District quartiere)
        {
            this.nome = nome;
            this.quartiere = quartiere;
        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public District getQuartiere() {
        return quartiere;
    }

    public void setQuartiere(District quartiere) {
        this.quartiere = quartiere;
    }
}

