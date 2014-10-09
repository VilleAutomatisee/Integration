package Ville;

public class Route  {

	private Voie 	    sens1;
	private Voie 	    sens2;

    // Les interface de la route sont ses entrees et sorties

    private Interface   entreeSortie;
    private Interface   sortieEntree;


    public Interface getEntreeSortie() {
        return entreeSortie;
    }

    public Interface getSortieEntree() {
        return sortieEntree;
    }

    public Route(int nbPositionRoute)
	{
		
	    Voie voie1 = new Voie(nbPositionRoute);
        Voie voie2 = new Voie(nbPositionRoute);

		this.sens1 = voie1;
        this.sens2 = voie2;


        // --------------->
        entreeSortie = new Interface(sens1.getEntreeVoie(), sens2.getSortieVoie());

        // <---------------
        sortieEntree = new Interface(sens2.getEntreeVoie(), sens1.getSortieVoie());
        if(entreeSortie ==null ) System.out.printf("c'est null");

	}

}
