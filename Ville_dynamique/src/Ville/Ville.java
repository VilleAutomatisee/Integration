package Ville;

import java.util.HashMap;

public class Ville {
	
	private int 	nbRoute;
	private boolean tournant;

    private int x;
    private int y;
    /**
     * Cette hashmap est simplement une suite d'objects positions blocks, à la suite, sans tenir compte de la position en 3D.
     */
    private HashMap positionsBlocs;


    /**
     * Construit une ville  : un rectangle/carré de X par Y
     */
    public Ville(int x, int y) {
        this.x = x;
        this.y = y;

        int index;

        PositionBloc tmp = null;
        for (i = 0; i <= this.x; i++) {
            for (j = 0; j <= this.y; j++) {
                // @TODO : créer les blocs, à la suite et les mettre dans la hashmap positionBlocs.
                //tmp      = new PositionBloc();
                index = index + 1;
            }
        }

        // @TODO : générer les éléments de la ville (route, chausée) sans voiture.
        // exemple : on démarre par une chausée sur la partie tout à gauche du carré de la ville
        // ensuite comme on détécte une chausée, on place une route à droite, etc...

        // @TODO : une fois qu'on a la ville, placer les voitures un peu aléatoirement sur la route, en respectant 2 carré d'écart entre chaque véhicule.
    }

    public void ajouterRoute(Route r) {

    }

    /**
     * Point d'entrée de l'application.
     *
     * @param args
     */
    public static void main(String[] args) {
        Ville springfield = new Ville(50, 100);

    }

}
