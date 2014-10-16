package Ville;

public class Route  {



	private Voie 	    sens1;
	private Voie 	    sens2;
    private Interface   entreeSortie;// Les interface de la route sont ses entrees et sorties
    private Interface   sortieEntree;




    public Route(int nbPositionRoute)
	{

		this.sens1               = new Voie(nbPositionRoute);
        this.sens2               = new Voie(nbPositionRoute);
        this.entreeSortie        = new Interface(sens1.getEntreeVoie(), sens2.getSortieVoie());// --------------->
        this.sortieEntree        = new Interface(sens2.getEntreeVoie(), sens1.getSortieVoie());// <---------------

	}

    public Interface getEntreeSortie() {
        return entreeSortie;
    }

    public Interface getSortieEntree() {
        return sortieEntree;
    }


}
