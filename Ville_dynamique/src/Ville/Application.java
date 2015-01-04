package Ville;

import Feux.Feux;

import java.util.ArrayList;
import java.util.List;

public class Application
{
    // point d'entrée de l'application.
    public static void main( String[] args )
    {
        // création de feux.
        Feux feux1 = new Feux( 5000, 150, 1500 );
        //Feux feux2 = new Feux( 2000, 0, 15000 );
        List<Feux> feux = new ArrayList<Feux>();
        feux.add( feux1 );
        //feux.add( feux2 );

        Ville v1            = new Ville( "Springfield", feux );

        // @TODO : saisie clavier.
        int nombreVoitures          = 1;
        ArrayList<Voiture> voitures = new ArrayList<Voiture>(nombreVoitures);

        int i;
        for( i = 0; i < nombreVoitures; i++ )
        {
            // @TODO : saisie noms voiture dynamique (saisie clavier)
            voitures.add( VoitureFactory.getInstance().createVoiture( "Peugeot", v1.getVoieAleatoire().getPosition( 1 ), 2 ) );
        }

        // démarrage des voitures.
        for( i = 0; i < nombreVoitures; i++ )
        {
            voitures.get( i ).start();
        }

        // démarrage des feux.
        for( i = 0; i < feux.size(); i++ )
        {
            feux.get( i ).start();
        }

        try
        {
            for( i = 0; i < feux.size(); i++ )
            {
                feux.get( i ).join();
            }
        }
        catch( Exception e )
        {
            System.err.println( "Une erreur est survenue lors de la terminaison des threads de feux." );
        }

        try
        {
            for( i = 0; i < nombreVoitures; i++ )
            {
                voitures.get( i ).join();
            }
        }
        catch( Exception e )
        {
            System.err.println( "Une erreur est survenue lors de la terminaison des threads de voitures." );
        }
    }
}
