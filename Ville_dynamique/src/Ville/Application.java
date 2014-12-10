package Ville;

/**
 * Created by lenzamba on 09/10/2014.
 */
public class Application {

    public static void main( String[] args )
    {
        Ville v1            = new Ville( "Springfield" );


        Voiture voiture1    = new Voiture( "Peugeot", v1.getVoieAleatoire().getPosition( 1 ), 2 );
        Voiture voiture2    = new Voiture( "Citroen", v1.getVoieAleatoire().getPosition( 5 ), 3 );

        voiture1.start();
        voiture2.start();

        try
        {
            voiture1.join();
            voiture2.join();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
