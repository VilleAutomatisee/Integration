package Ville;

import java.util.Random;

public class Route
{
	private Voie 	    sens1;
	private Voie        sens2;
    private PositionBloc intersectionSortie;
    private PositionBloc intersectionEntree;

    public Route( String nom, int nbPositionRoute )
    {
        // S <-------- E
        this.sens2 = new Voie( nom, nbPositionRoute, 2 );
        // E ---------> S
        this.sens1 = new Voie( nom, nbPositionRoute, 1 );

        // protocole : on admet que la sortie est celle du sens1, l'entrée aussi.
        // Entrée ----> Sortie
        this.intersectionEntree = null;
        this.intersectionSortie = null;
    }

    public Voie getSens2()
    {
        return sens2;
    }

    public Voie getSens1()
    {
        return sens1;
    }

    /**
     * Connection d'une route 1 vers une route 2 (intersection).
     */
    public void liaison( Route r2, String direction1, String direction2, PositionBloc intersection )
    {
        // une liaison se fait de la façon suivante :
        // pour créer les liaisons, on utilise un PostitionBlocs (qui est l'object verrouillé, une seul voiture par position bloc).
        // ainsi, pour passer une intersection/carrefour, etc..., il ne peut y avoir qu'une voiture à la fois.

        // connexion sortie vers sortie.
        if( direction1.equals( "s" ) && direction2.equals( "s" ) )
        {
            // connexion route 1 sens 1 vers route 2 sens 2
            intersection.addSuivant(r2.getSens2().getEntreeVoie());
            //this.sens1.addBlocSuivant( intersection );
            this.getSens1().getSortieVoie().addSuivant( intersection );

            // connexion route 2 sens 1 vers route 1 sens 1.
            intersection.addSuivant(this.getSens2().getEntreeVoie());
            //r2.getSens1().addBlocSuivant(intersection);
            r2.getSens1().getSortieVoie().addSuivant(intersection);
        }
        // connexion entrée vers sortie OU sortie vers entrée
        else if( (direction1.equals( "e" ) && direction2.equals( "s" )) || (direction1.equals( "s" ) && direction2.equals( "e" )) )
        {
            // connexion route 1 sens 2 vers route 2 sens 2
            //this.getSens2().addBlocSuivant( intersection );
            this.getSens2().getSortieVoie().addSuivant( intersection );
            intersection.addSuivant( r2.getSens2().getEntreeVoie() );

            // connexion route 2 sens 1 vers route 1 sens 2
            //r2.getSens1().addBlocSuivant( intersection );
            r2.getSens1().getSortieVoie().addSuivant( intersection );
            intersection.addSuivant( this.getSens1().getEntreeVoie() );
        }
        // connexion entrée vers entrée.
        else if( direction1.equals( "e" ) && direction2.equals( "e" ) )
        {
            // connexion route 1 sens 2 vers route 2 sens 1
            //this.getSens2().addBlocSuivant( intersection );
            this.getSens2().getSortieVoie().addSuivant( intersection );
            intersection.addSuivant( r2.getSens1().getEntreeVoie() );

            // connexion route 2 sens 2 vers route 1 sens 1
            //r2.getSens2().addBlocSuivant( intersection );
            r2.getSens2().getSortieVoie().addSuivant( intersection );
            intersection.addSuivant( this.getSens1().getEntreeVoie() );
        }

        // @TODO : vérifier que notre block intersection ne contient pas de doublons (exemple : plusieurs fois la même sortie si on a fait trop de connexions)
    }

    public Voie getEntreeAleatoire()
    {
        Random rand = new Random();
        int sens = rand.nextInt( 1 );
        if( sens == 1 )
        {
            return this.getSens1();
        }
        else
        {
            return this.getSens2();
        }
    }

    public PositionBloc getIntersectionSortie() {
        return intersectionSortie;
    }

    public PositionBloc getIntersectionEntree() {
        return intersectionEntree;
    }

    @Override
    public String toString() {
        return "\nRoute {" +
                "\nsens1=" + sens1 +
                ", \nsens2=" + sens2 +
                "\n}\n\n";
    }
}
