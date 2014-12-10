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
        Voie voie                   = new Voie( "Rue de Lille"         , 16 );
        Voie voie2                  = new Voie( "Rue de Metz"          , 13 );
        Voie voie3                  = new Voie( "Allée des Lilas"      , 5  );
        Voie voie4                  = new Voie( "Rue de la liberté"    , 5  );

        this.listVoies.add(voie);
        this.listVoies.add(voie2);
        this.listVoies.add(voie3);
        this.listVoies.add(voie4);

        // On cree un carrefour : 4 Routes et un Carrefour

        Route r1         = new Route( "Avenue de la république"     , 3 );
        Route r2         = new Route( "Rue Turgot"                  , 5 );
        Route r3         = new Route( "Rue Rouget de Lisle"         , 4 );
        Route r4         = new Route( "Avenue Maurice Bertaux"      , 8 );
        Route r5         = new Route( "Avenue Jules Ferry"          , 3 );
        Route r6         = new Route( "Rue Montgolifier"            , 5 );
        Route r7         = new Route( "Rue Marie louise"            , 4 );
        Route r8         = new Route( "Rue de Mont Royal"           , 8 );
        Route r9         = new Route( "Avenue Jean Baptiste Chauvin", 3 );
        Route r10        = new Route( "Rue Manel Gharbi"            , 5 );
        Route r11        = new Route( "Rue Nzamba-Maleck "          , 4 );
        Route r12        = new Route( "Rue Dumouchelle Kev"         , 8 );



        this.listRoute.add( r1 );
        this.listRoute.add( r2 );
        this.listRoute.add( r3 );
        this.listRoute.add( r4 );
        this.listRoute.add( r5 );
        this.listRoute.add( r6 );
        this.listRoute.add( r7 );
        this.listRoute.add( r8 );



        // Connection des routes entres elles en cycle


        r1.getEntreeSortie().connectRoute( r2.getSortieEntree() );
        r1.getSortieEntree().connectRoute( r3.getEntreeSortie() );
        r2.getEntreeSortie().connectRoute( r4.getSortieEntree() ); // R1 , R2 DONE
        r3.getSortieEntree().connectRoute( r5.getEntreeSortie() ); // R3 DONE
        r4.getEntreeSortie().connectRoute( r6.getEntreeSortie() ); // R4 , R5
        r5.getSortieEntree().connectRoute( r7.getSortieEntree() );
        r6.getSortieEntree().connectRoute( r8.getEntreeSortie() );
        r7.getEntreeSortie().connectRoute( r8.getSortieEntree() );


        System.out.println(r1.getEntreeAleatoire());
        voie.connectionEntree(r1.getEntreeAleatoire());
        voie.connectionSortie(r2.getEntreeAleatoire());

        voie2.connectionSortie(r7.getEntreeAleatoire());
        voie2.connectionEntree(r8.getEntreeAleatoire());

        voie3.connectionSortie(r4.getEntreeAleatoire());
        voie3.connectionEntree(r5.getEntreeAleatoire());

        voie4.connectionSortie(r3.getEntreeAleatoire());
        voie4.connectionEntree(r4.getEntreeAleatoire());

        // Dans notre projet on considère qu'un carrefour est constitué de 4 directions : nord - sud - est - ouest

    }




    public Voie getVoieAleatoire()
    {
        Random rand                     = new Random();
        int indiceRouteAleatoire        = rand.nextInt( this.listRoute.size() );

        return this.listRoute.get(indiceRouteAleatoire).getEntreeAleatoire();
    }


    public void addVoie( Voie voie )
    {
        this.listVoies.add(voie);
    }
}
