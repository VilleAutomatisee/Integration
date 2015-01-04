package Ville;

import Feux.Feux;
import AgentSecurite.AgentSecurite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application
{
    // point d'entrée de l'application.
    public static void main( String[] args )
    {
        // création de feux.

        List<Feux>  feux            = new ArrayList<Feux>();
        List<AgentSecurite> agentSecurites = new ArrayList<AgentSecurite>();
        List<Voiture> voitures      = new ArrayList<Voiture>();



        Feux feux1                  = new Feux( 5000, 150, 1500 );
        feux.add( feux1 );


        Ville v1                    = new Ville( "Springfield", feux );

        System.out.println("Combien des agents de securite souhaitez vous créer ?");
        Scanner sc                  = new Scanner(System.in);
        int  nb_pieton              = sc.nextInt();

        for (int i = 0 ; i < nb_pieton  ; i++)
        {
            int j = 1 + i;

            System.out.println("Prenom de l'agent n°"+j+" : ");
            sc                      = new Scanner(System.in);
            String  nom_pieton      = sc.nextLine();

            AgentSecurite p                = new AgentSecurite(nom_pieton);
            PositionBloc po         = v1.getVoieAleatoire().getBlockAleatoire();

            p.setPositionBloc(po);
            po.setAgentSecurite(p);
            agentSecurites.add(p);
        }


        System.out.println("Combien de voiture souhaitez vous créer ?");
        sc                          = new Scanner(System.in);
        int  nombreVoitures         = sc.nextInt();

        for (int i = 0 ; i < nombreVoitures  ; i++)
        {
            int j = 1 + i;

            System.out.println("[Modele_Marque] de la voiture n°"+j+" : ");
            Scanner sc2             = new Scanner(System.in);
            String  nom             = sc2.nextLine();

            voitures.add( VoitureFactory.getInstance().createVoiture( nom+"_"+j , v1.getVoieAleatoire().getPosition( 1 ), 2 ) );
        }



        int i;

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

        // circulation des pietons .
        for( i = 0; i < agentSecurites.size(); i++ )
        {
            agentSecurites.get( i ).start();
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

        try
        {
            for( i = 0; i < nb_pieton; i++ )
            {
                agentSecurites.get( i ).join();
            }
        }
        catch( Exception e )
        {
            System.err.println( "Une erreur est survenue lors de la terminaison des threads de voitures." );
        }
    }
}
