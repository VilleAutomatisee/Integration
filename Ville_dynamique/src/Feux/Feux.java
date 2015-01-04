package Feux;

import Ville.PositionBloc;

public class Feux extends Thread
{
    FeuxState feux ;

    int dureeFeuxRouge ;
    int dureeFeuxOrange ;
    int dureeFeuxVert ;

    PositionBloc position ;

    public Feux()
    {
        this.dureeFeuxRouge     = 1000 ;
        this.dureeFeuxOrange    = 100 ;
        this.dureeFeuxVert      = 2000 ;
        this.feux               = new StateFeuxVert();
        this.position           = null;
    }

    public Feux( int dureeFeuxRouge, int dureeFeuxOrange, int dureeFeuxVert )
    {
        this.dureeFeuxRouge     = dureeFeuxRouge;
        this.dureeFeuxOrange    = dureeFeuxOrange;
        this.dureeFeuxVert      = dureeFeuxVert ;
        this.feux               = new StateFeuxVert();
        this.position           = null;
    }

    @Override
    public void run()
    {
        // on run seulement si le feux est bien placé sur la ville.
        if( this.position != null )
        {
            while ( true )
            {
                try
                {
                    sleep( this.feux.getDureeCouleur( this ) );
                    this.feux.couleurSuivante( this );
                    System.out.println("Feux de circulation passe à la couleur : " + this.getCurrentState());
                    this.getPositionBloc().notifyChangementFeux();
                }
                catch( Exception e )
                {
                    e.printStackTrace();
                }

            }
        }
    }

    public void setState( FeuxState feux )
    {
        this.feux = feux;
    }

    public int getDureeFeuxRouge() {
        return dureeFeuxRouge;
    }

    public int getDureeFeuxOrange() {
        return dureeFeuxOrange;
    }

    public int getDureeFeuxVert() {
        return dureeFeuxVert;
    }

    public String getCurrentState()
    {
        if( this.feux instanceof StateFeuxVert )
        {
            return "vert";
        }
        else if( this.feux instanceof StateFeuxOrange )
        {
            return "orange";
        }

        return "rouge";
    }

    public void setPositionBloc( PositionBloc p )
    {
        this.position = p;
    }

    public PositionBloc getPositionBloc()
    {
        return this.position;
    }
}
