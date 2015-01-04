package AgentSecurite;

/**
 * Created by leite_2 on 04/01/2015.
 */
public class StateSurLeTrottoir implements AgentSecuriteState {

    private final String             nom        = "trottoir";
    private final int                vitesse    = 500;

    public StateSurLeTrottoir() { }

    @Override
    public int getVitesseDeplacement() {
        return vitesse;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setPietonStateSuivant(AgentSecurite p) {
        p.setEmplacementPieton(new StateSurLaRoute());
    }
}
