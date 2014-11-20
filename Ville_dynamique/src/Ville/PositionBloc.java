package Ville;

public class PositionBloc
{

    private String nom;
    int num;
    private PositionBloc                            suivant;
    private PositionBloc                            sortie; // --- TO DO : Voir si n'y a pas moyen de faire de l'héritage --> FLEME
    private boolean                                 debut;
    private Voiture                                 voiturePresente;

    public PositionBloc(String nom, int num, boolean debut )
    {
        this.nom = nom;
        this.num = num;
        this.suivant            =null;
        this.sortie             = null;
        this.debut              = debut ;
        this.voiturePresente    = null ;
    }

    public PositionBloc()
    {
        // Constructeur pour les positions d'un carrefour
        this.suivant            =null;
        this.sortie             = null;
        this.debut=false;
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
    public void setSuivant( PositionBloc p )
    {
        this.suivant = p;
    }

    public void setVoiturePresente(Voiture v)
    {
        this.voiturePresente = v;
    }

    public PositionBloc getSuivant()
    {
        return suivant;
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
