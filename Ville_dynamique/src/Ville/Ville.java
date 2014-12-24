package Ville;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Ville
{
    private int nbRoute;
    private int nbVoie;

    private ArrayList<Route> routes;
    private String nom;

    public Ville( String nom )
    {
        this.nom            = nom;
        routes              = new ArrayList<Route>();

        this.generateurVille();
    }

    private void generateurVille()
    {
        // on créer les routes dans la ville.
        Route r1            = new Route( "Avenue de la république"          , 3 );
        Route r2            = new Route( "Rue Turgot"                       , 5 );
        Route r3            = new Route( "Rue Berthelot"                    , 4 );
        Route r4            = new Route( "Rue Cuvier"                       , 5 );

        routes.add( r1 );
        routes.add( r2 );
        routes.add( r3 );
        routes.add( r4 );

        PositionBloc intersection1 = new PositionBloc();
        r2.liaison( r1, "s", "s", intersection1);
        r1.liaison( r3, "s", "e", intersection1 );
        r3.liaison( r1, "e", "s", intersection1 );

        PositionBloc intersection2 = new PositionBloc();
        r2.liaison( r4, "e", "e", intersection2 );

        PositionBloc intersection3 = new PositionBloc();
        r1.liaison( r4, "s", "s", intersection3 );
        //System.out.println( r4 );

        System.out.println( "Intersection\n\n" + intersection3 );
    }

    public Voie getVoieAleatoire()
    {
        Random rand                     = new Random();
        int indiceRouteAleatoire        = rand.nextInt(this.routes.size());

        return this.routes.get( indiceRouteAleatoire ).getEntreeAleatoire();
    }
}
