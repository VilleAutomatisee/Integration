package Ville;

import java.util.ArrayList;
import java.util.List;

public class PositionBloc
{

    private String                                  nom;
    private int                                     num;
    private List<PositionBloc>                      listeSuivants;

    private boolean                                 debut;
    private Voiture                                 voiturePresente;

    public PositionBloc( String nom, int num, boolean debut )
    {
        this.nom                = nom;
        this.num                = num;
        this.listeSuivants      = new ArrayList<PositionBloc>();
        this.debut              = debut ;
        this.voiturePresente    = null ;
    }

    public PositionBloc()
    {
        // constructeur pour les positions d'un carrefour
        this.nom                = "Intersection";
        this.num                = 0;
        this.listeSuivants      = new ArrayList<PositionBloc>();
        this.debut              = true ;
        this.voiturePresente    = null ;
    }

    public synchronized void Prend( Voiture v )
    {
        while ( voiturePresente != null ) {
            try
            {
                System.out.println( v.getNom()+" en attente." );
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


}
