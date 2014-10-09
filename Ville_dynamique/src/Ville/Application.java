package Ville;

/**
 * Created by lenzamba on 09/10/2014.
 */
public class Application {

    public static void main(String[] args) {

        Voie voie        = new Voie(16);
        Voie voie2       = new Voie(13);
        Voie voie3       = new Voie(5);

        voie.connection(voie2);

        Voiture voiture1 = new Voiture(voie.getFinVoie());

        voiture1.avancerVoiture();

    }
}
