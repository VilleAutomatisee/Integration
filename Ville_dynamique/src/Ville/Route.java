package Ville;

public class Route  {

	private Voie 	    sens1;
	private Voie 	    sens2;

    // Les interface de la route sont ses entrees et sorties

    private Interface   entree;
    private Interface   sortie;


	public Route(int nbPositionRoute)
	{
		
	    Voie voie1 = new Voie(nbPositionRoute);
        Voie voie2 = new Voie(nbPositionRoute);

		this.sens1 = voie1;
        this.sens2 = voie2;



	}

}
