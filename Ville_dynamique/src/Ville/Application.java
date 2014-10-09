package Ville;

/**
 * Created by lenzamba on 09/10/2014.
 */
public class Application {

    public static void main(String[] args) {

        Voie voie        = new Voie(16);
        Voie voie2       = new Voie(13);
        Voie voie3       = new Voie(5);

        // On cree un carrefour : 4 Routes et un Carrefour
        Route r1         = new Route(3);
        Route r2         = new Route(5);
        Route r3         = new Route(4);
        Route r4         = new Route(8);

        // Dans notre projet on considère qu'un carrefour est constitué de 4 directions : nord - sud - est - ouest
        Carrefour c      = new Carrefour();

        c.getFaceOuest().connectRoute(r1.getEntreeSortie());
        c.getFaceEst().connectRoute(r2.getEntreeSortie());
        c.getFaceNorth().connectRoute(r3.getEntreeSortie());
        c.getFaceSouth().connectRoute(r4.getEntreeSortie());

        voie.connection(voie2);

        Voiture voiture1 = new Voiture(voie.getSortieVoie());

        voiture1.avancerVoiture();

    }
}
