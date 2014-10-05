package Ville;

import java.util.ArrayList;
import java.util.Random;

public class Ville {
	
	private int 	nbRoute;
	private boolean tournant;

    private int x;
    private int y;
    /**
     * Cette hashmap est simplement une suite d'objects positions blocks, à la suite, sans tenir compte de la position en 3D.
     */
    private ArrayList<PositionBloc> positionsBlocs;


    /**
     * Construit une ville  : un rectangle/carré de X par Y
     */
    public Ville( int x, int y )
    {
        this.x              = x;
        this.y              = y;
        this.positionsBlocs = new ArrayList<PositionBloc>( x * y );

        PositionBloc positionCourante       = null;
        PositionBloc precedent              = null; // on stock le précédent, ainsi lorsqu'on créer le 2e bloc par exemple, on a une référence vers le 1er
                                                    // et on peut faire 1er block.setSuivant( 2e block ), etc...

        int index = 0;
        int i, j;
        for ( i = 0; i <= this.x; i++ )
        {
            for ( j = 0; j <= this.y; j++ )
            {
                positionCourante     = new PositionBloc( i, j, index );
                positionCourante.setSuivant( precedent );
                this.positionsBlocs.add(index, positionCourante);  // on stock le block dans une liste (key = bricolage  : i et j à la suite dans une string...).
                precedent   = positionCourante;                         // on peut maintenant garder une référence, pour la tour suivant.

                index       = index + 1;
            }
        }


        // On génére les différents éléments de la ville.
        // Exemple : on démarre par une chausée sur la partie tout à gauche du carré de la ville
        // ensuite comme on détécte une chausée, on place une route à droite, etc...
        int num, result ;
        index = 0;

        positionCourante = null;

        for ( i = 0; i <= this.x; i++ )
        {
            for ( j = 0; j <= this.y; j++ )
            {
                // Simulation de pourcentage (on veut 85 % des fois une route, et le reste [15%] des fois un carrefour.
                Random rand = new Random();
                result      = rand.nextInt( 100 );

                // on récupère le bloc courant, à l'aide de la clé (i+j) bricolées lors de la génération.
                positionCourante = (PositionBloc) this.positionsBlocs.get( index );

                // @TODO : continuer ici.

                if( result <= 15 )  // 15% de chance d'avoir un carrefour
                {

                }
                else //85 % de chance d'avoir une route
                {

                }

                index       = index + 1;
            }
        }

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
