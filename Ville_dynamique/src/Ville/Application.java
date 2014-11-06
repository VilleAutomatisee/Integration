package Ville;

/**
 * Created by lenzamba on 09/10/2014.
 */
public class Application {

    public static void main(String[] args)
    {
        Ville v1    = new Ville();
        Voie voie   = new Voie( 50 );

        voie.afficheVoie();
        Voiture voiture1    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();
        Voiture voiture2    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();
        //Voiture voiture3    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();
        //Voiture voiture4    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();

        voie.circuler();

        voie.afficheVoie();
    }
}
