package Utility;

/**
 * Created by Davide on 18/04/2017.
 */
public class Via
{

        private String nome;
        private Quartiere quartiere;

	public Via(String nome, Quartiere quartiere)
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

    public Quartiere getQuartiere() {
        return quartiere;
    }

    public void setQuartiere(Quartiere quartiere) {
        this.quartiere = quartiere;
    }
}

