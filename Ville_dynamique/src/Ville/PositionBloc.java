package Ville;

public class PositionBloc {
	/*

	private int id;
	private int positionX;
    private int positionY;

    */


    private PositionBloc                            suivant;
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
}
