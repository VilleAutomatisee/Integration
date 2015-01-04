package AgentSecurite;

import Ville.PositionBloc;

/**
 * Created by leite_2 on 04/01/2015.
 */
public class AgentSecurite extends Thread {

    private AgentSecuriteState emplacementPieton;
    private String              nom;
    private PositionBloc        position;


    public AgentSecurite(String nom)
    {
        this.nom                    = nom;
        this.emplacementPieton      = new StateSurLeTrottoir();
        this.position               = null;
    }


    @Override
    public void run()
    {
        while (true ) {
            try {

                this.emplacementPieton.setPietonStateSuivant(this);
                sleep(this.emplacementPieton.getVitesseDeplacement());
                System.out.println( this.getNom() + " actuellement sur " + this.emplacementPieton.getNom());
                this.getPosition().notifyChangementFeux();
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    public void setEmplacementPieton(AgentSecuriteState emplacementPieton) {
        this.emplacementPieton = emplacementPieton;
    }

    public String getEmplacementPieton() {
        return emplacementPieton.getNom();
    }

    public String getNom() {
        return nom;
    }

    public PositionBloc getPosition() {
        return this.position;
    }

    public void setPositionBloc( PositionBloc p )
    {
        this.position = p;
    }

}
