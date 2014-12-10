package Ville;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Ville
{
    private List<Route>         listRoute;
    private List<Voie>          listVoies;
    private List<Voiture>       listVoiture;

    private int nbRoute;
    private int nbVoie;

    private String nom;

    public Ville( String nom )
    {
        this.listRoute      = new ArrayList<Route>();
        this.listVoies      = new ArrayList<Voie>();
        this.listVoiture    = new ArrayList<Voiture>();

        this.generateurVille();

        this.nom            = nom;
    }

    private void generateurVille()
    {
        // On cree un carrefour : 4 Routes et un Carrefour
        Route r1         = new Route( "Route de la Paix1", 3 );
        Route r2         = new Route( "Route de la Paix12", 5 ); 

        r2.getEntreeSortie().connectRoute(r1.getSortieEntree());
        Voie v1         = new Voie("rue de la liberation",5);

        this.listRoute.add( r1 );
        this.listRoute.add( r2 );
     //   this.listRoute.add( r3 );
     //   this.listRoute.add( r4 );

        Voiture v1 = new Voiture();
        //Voiture v2 = new Voiture();

        this.listVoiture.add( v1 );
      //  this.listVoiture.add( v2 );
    }

    public Voie getVoieAleatoire()
    {
        Random rand                 = new Random();
        int indiceRouteAleatoire    = rand.nextInt( this.listRoute.size() );
        return this.listRoute.get(indiceRouteAleatoire).getEntreeAleatoire();
    }

    public void addVoie( Voie voie )
    {
        this.listVoies.add(voie);
    }
}
