package Ville;

import java.util.ArrayList;
import java.util.List;
import Feux.*;

public class PositionBloc
{
    private String                                  nom;
    private int                                     num;
    private List<PositionBloc>                      listeSuivants;

    private boolean                                 debut;
    private Voiture                                 voiturePresente;

    private Feux                                    feux;

    public PositionBloc( String nom, int num, boolean debut )
    {
        this.nom                = nom;
        this.num                = num;
        this.listeSuivants      = new ArrayList<PositionBloc>();
        this.debut              = debut ;
        this.voiturePresente    = null ;
        this.feux               = null ;
    }

    public PositionBloc()
    {
        // constructeur pour les positions d'un carrefour
        this.nom                = "Intersection";
        this.num                = 0;
        this.listeSuivants      = new ArrayList<PositionBloc>();
        this.debut              = true ;
        this.voiturePresente    = null ;
        this.feux               = null;
    }

    public synchronized void Prend( Voiture v )
    {
        // si il y a une voiture déjà présente sur ce block, ou bien si on rencontre un feux rouge, alors attente.
        while ( (voiturePresente != null) || ( this.feux != null && this.feux.getCurrentState().equals( "rouge" )) )
        {
            try
            {
                if( voiturePresente != null )
                {
                    System.out.println( v.getNom() + " en attente, voiture présente devant." );
                }
                else if( this.feux != null && this.feux.getCurrentState().equals( "rouge" ) )
                {
                    System.out.println( v.getNom() + " en attente, feux rouge rencontré." );
                }

                wait();
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }

        voiturePresente = v;
    }

    public synchronized void Libere()
    {
        voiturePresente = null;
        notifyAll();
    }

    public synchronized void notifyChangementFeux()
    {
        notifyAll();
    }

    /**
     * Getters - setters
     */
    public void addSuivant( PositionBloc p )
    {
        this.listeSuivants.add( p );
    }

    public void setVoiturePresente( Voiture v )
    {
        this.voiturePresente = v;
    }

    public List<PositionBloc> getSuivants()
    {
        return listeSuivants;
    }

    public PositionBloc getSuivant( int i )
    {
        return this.listeSuivants.get( i );
    }

    public Voiture getVoiturePresente()
    {
        return voiturePresente;
    }

    @Override
    public String toString()
    {
        if( nom.equals( "Intersection" ) )
        {
            //return new String( num+" "+nom + " " + listeSuivants );
        }

        return new String( num+" "+nom + " " );
    }

    public void setFeux( Feux feux )
    {
        // si pas de feux, on le créer.
        this.feux = feux;
        this.feux.setPositionBloc( this );
    }

}
