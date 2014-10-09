package Ville;

public class PositionBloc {
	/*

	private int id;
	private int positionX;
    private int positionY;

    */


    private PositionBloc                            suivant;



    //------------------------------------------------------------------------------ réservé aux carrefours
    // --- TO DO : Voir si n'y a pas moyen de faire de l'héritage --> FLEME
    private PositionBloc                            sortie;
    //------------------------------------------------------------------------------ fin

    private boolean                                 debut;
    private Voiture                                 voiturePresente;

	
	/*
	public PositionBloc( int positionX, int positionY, int id )
    {
		this.positionX  = positionX;
        this.positionY  = positionY;
        this.id         = id;
		this.setSuivant( null );
	}
	*/

    public PositionBloc(boolean debut)
    {
        this.debut              = debut ;
        this.voiturePresente    = null ;
    }

    // Constructeur pour les positions d'un carrefour
    public PositionBloc() {
        this.voiturePresente = null ;
        this.sortie = null;
    }


    /**
     * Getters - setters
     */
    public void setSuivant( PositionBloc p )
    {
        this.suivant = p;
    }


    public void setVoiturePresente(Voiture v) {
        this.voiturePresente = v;
    }

    public PositionBloc getSuivant() {
        return suivant;
    }

    public Voiture getVoiturePresente() {
        return voiturePresente;
    }


    public void setSortie(PositionBloc sortie) {
        this.sortie = sortie;
    }


}
