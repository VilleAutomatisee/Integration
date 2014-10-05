package Ville;

public class PositionBloc {
	private int id;
	private int positionX;
    private int positionY;

	private PositionBloc suivant;
	
	
	public PositionBloc( int positionX, int positionY, int id )
    {
		this.positionX  = positionX;
        this.positionY  = positionY;
        this.id         = id;
		this.setSuivant( null );
	}

    /**
     * Getters - setters
     */
    public void setSuivant( PositionBloc p )
    {
        this.suivant = p;
    }
}
