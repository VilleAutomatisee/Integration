package Ville;

/**
 * Created by lenzamba on 09/10/2014.
 */
public class Application {

    public static void main(String[] args)
    {
       // Ville v1    = new Ville();
        Voie voie   = new Voie("rue de la liberation", 50 );

        //v1.addVoie( voie );

        voie.afficheVoie();
        Voiture voiture1    = new Voiture("Peugeot", voie.getEntreeVoie(), 2 );

        //voie.afficheVoie();
        Voiture voiture2    = new Voiture("Citroen", voie.getPosition(1),1 );

        //Voiture voiture3    = new Voiture( voie.getEntreeVoie() );
        //Voiture voiture4    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();
        //Voiture voiture3    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();
        //Voiture voiture4    = new Voiture( voie.getEntreeVoie() );

        //voie.afficheVoie();

        voiture1.start();
        voiture2.start();

        voie.afficheVoie();
        try {
            voiture1.join();
            voiture2.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
