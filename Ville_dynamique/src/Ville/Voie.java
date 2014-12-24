package Ville;

import java.util.ArrayList;

public class Voie
{
    private String nom;
    private ArrayList<PositionBloc> blocs;
    private int sens;

    public Voie( String nom, int nbPositionBloc, int sens )
    {
        this.nom                        = nom;
        this.blocs                      = new ArrayList<PositionBloc>();
        this.sens                       = sens;

        this.genPositionBloc( nbPositionBloc );
    }

    // Génération de la liste chainée de taille [nbPositionBloc] PositionBloc
    private void genPositionBloc( int nbPositionBloc )
    {
        PositionBloc position           = null;
        PositionBloc positionNouvelle   = null;
        int numeroVoie                  = 0;

        // création manuelle du premier bloc de la voie.
        if( this.sens == 1 )
        {
            position    = new PositionBloc( nom, 2, true );
        }
        else
        {
            position    = new PositionBloc( nom, 1, true );
        }

         for( int i = 1 ; i <= nbPositionBloc  ; i++ )
        {
            numeroVoie = i*2;
            // numéros de rue pair à droite, et impair à gauche
            if( this.sens == 1 )
            {
                if( numeroVoie % 2 != 0 )
                {
                    numeroVoie = numeroVoie + 1 ;
                }
            }
            else
            {
                if( numeroVoie % 2 == 0 )
                {
                    numeroVoie  = numeroVoie - 1;
                }
            }

            positionNouvelle = new PositionBloc( nom , numeroVoie , false );
            position.addSuivant( positionNouvelle );
            position = positionNouvelle ;
            this.blocs.add( position );
        }
    }

    public PositionBloc getBlockAleatoire()
    {
        int b = (int) Math.random()*this.blocs.size();
        return this.blocs.get( b );
    }
    
    public PositionBloc getPosition( int i )
    {
        return this.blocs.get(i);
    }

    public PositionBloc getEntreeVoie()
    {
        return this.blocs.get( 0 );
    }

    public PositionBloc getSortieVoie()
    {
        return this.blocs.get( this.blocs.size()-1 );
    }

    public void addBlocSuivant( PositionBloc p )
    {
        this.blocs.add( p );
    }

    @Override
    public String toString() {
        return "Voie{" +
                "nom='" + nom + '\'' +
                ", taille voie=" + blocs.size() +
                '}';
    }
}
