package Ville;

import java.util.ArrayList;

public class Voiture extends Thread
{
    private String nom;
    private PositionBloc positionActuelle;
    private int vitesse;

    public Voiture()
    {

    }

    public Voiture( String nom, PositionBloc p, int vitesse )
	{
        this.nom                    = nom;
        this.positionActuelle       = p;
        this.vitesse                = vitesse;
        this.positionActuelle.setVoiturePresente(this);
	}

    public PositionBloc getPositionActuelle()
    {
        return positionActuelle;
    }

    public String getNom()
    {
        return nom;
    }

	public boolean avancerVoiture()
	{
        int nombreBlocksSuivants    = positionActuelle.getSuivants().size();
        int i                       = (int) (Math.random() * nombreBlocksSuivants);

        if ( nombreBlocksSuivants == 0 )
        {
            System.out.println( "A la fin de la voie. Plus aucun block trouvé ("+ nombreBlocksSuivants +")." ) ;
            return false;
        }

        PositionBloc positionsuivante = positionActuelle.getSuivant( i );

        if ( positionsuivante == null )
        {
            System.out.println( "A la fin de la voie. Plus aucun chemin possible." );
            return false;
        }

        System.out.println( nom+ " | " + positionActuelle + " --> "+positionActuelle.getSuivant( i ) );

        positionActuelle.getSuivant( i ).Prend( this );
        positionActuelle.Libere();
        positionActuelle = positionActuelle.getSuivant( i );
        return true;
	}

    public void run()
    {
        System.out.println( "Run voiture thread\n" );
        boolean fin=false;
        while ( !fin ) {
                 try {
                    fin= !this.avancerVoiture();
                    sleep(1000/vitesse);
                }catch(Exception e){
                     e.printStackTrace();
                 }

        }

    }
}
