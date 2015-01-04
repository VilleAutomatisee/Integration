package AgentSecurite;

/**
 * Created by leite_2 on 04/01/2015.
 */
public class StateSurLaRoute implements AgentSecuriteState {

    private final String             nom = "route" ;
    private final int                vitesse = 250;

    public StateSurLaRoute(){}

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
        p.setEmplacementPieton(new StateSurLeTrottoir());
    }
}
