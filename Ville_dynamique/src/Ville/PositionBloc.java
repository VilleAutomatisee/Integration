package Ville;

import java.util.ArrayList;
import java.util.List;

public class PositionBloc
{

    private String                                  nom;
    private int                                     num;
    private List<PositionBloc>                      listeSuivants;
    private PositionBloc                            sortie;

    private boolean                                 debut;
    private Voiture                                 voiturePresente;

    public PositionBloc(String nom, int num, boolean debut )
    {
        this.nom                = nom;
        this.num                = num;
        this.listeSuivants      = new ArrayList<PositionBloc>();
        this.sortie             = null;
        this.debut              = debut ;
        this.voiturePresente    = null ;
    }

    public PositionBloc()
    {
        // Constructeur pour les positions d'un carrefour
        this.listeSuivants      = new ArrayList<PositionBloc>();
        this.sortie             = null;
        this.debut              = false;
        this.voiturePresente    = null ;

    }

    public synchronized void Prend(Voiture v) {
        while ( voiturePresente!=null ) {
            try {
                System.out.println( v.getNom()+" Wait" );
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        voiturePresente = v;
    }
    public synchronized void Libere() {
        voiturePresente=null;
        notifyAll();
    }

    /**
     * Getters - setters
     */
    public void addSuivant(PositionBloc p)
    {
        this.listeSuivants.add( p );
    }

    public void setVoiturePresente(Voiture v)
    {
        this.voiturePresente = v;
    }

    public List<PositionBloc> getSuivants()
    {
        return listeSuivants;
    }
    public PositionBloc getSuivant( int i )
    {
        //System.out.println( "Je passe au suivant d'index " + i );
        return this.listeSuivants.get( i );
    }

    public Voiture getVoiturePresente()
    {
        return voiturePresente;
    }

    public void setSortie(PositionBloc sortie)
    {
        this.sortie = sortie;
    }
    @Override
    public String toString() {
        return new String(num+" "+nom);
    }


}
