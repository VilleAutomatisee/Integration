package Ville;

import java.util.ArrayList;

public class Application
{
    // point d'entrée de l'application.
    public static void main( String[] args )
    {
        Ville v1            = new Ville( "Springfield" );

        // @TODO : saisie clavier.
        int nombreVoitures          = 3;
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

        try
        {
            for( i = 0; i < nombreVoitures; i++ )
            {
                voitures.get( i ).join();
            }
        }
        catch( Exception e )
        {
            System.err.println( "Une erreur est survenue lors de la terminaison des threads." );
        }
    }
}
