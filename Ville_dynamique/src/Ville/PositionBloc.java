package Ville;

public class PositionBloc
{

    private PositionBloc                            suivant;
    private PositionBloc                            sortie; // --- TO DO : Voir si n'y a pas moyen de faire de l'héritage --> FLEME
    private boolean                                 debut;
    private Voiture                                 voiturePresente;



    public PositionBloc(boolean debut)
    {
        this.debut              = debut ;
        this.voiturePresente    = null ;
    }


    public PositionBloc()
    {
        // Constructeur pour les positions d'un carrefour
        this.voiturePresente    = null ;
        this.sortie             = null;
    }

    public synchronized void Prend(Voiture v) {
        while ( voiturePresente!=null ) {
            try {
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


}
