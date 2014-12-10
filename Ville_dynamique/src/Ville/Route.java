package Ville;

import java.util.Random;

public class Route
{
	private Voie 	    sens1;
	private Voie        sens2;

    private Interface   entreeSortie; // les interface de la route sont ses entrees et sorties
    private Interface   sortieEntree;

    public Route( String nom, int nbPositionRoute )
    {
        this.sens1 = new Voie(nom, nbPositionRoute);
        System.out.println(this.sens1);
        this.sens2 = new Voie(nom, nbPositionRoute);
        System.out.println(this.sens2);
        this.entreeSortie = new Interface(this.sens1.getEntreeVoie(), this.sens2.getSortieVoie());    // --------->
        this.sortieEntree = new Interface(this.sens2.getEntreeVoie(), this.sens1.getSortieVoie());    // <--------

    }


    public Interface getEntreeSortie()
    {
        return entreeSortie;
    }

    public Interface getSortieEntree()
    {
        return sortieEntree;
    }

    public Voie getSens2()
    {
        return sens2;
    }

    public Voie getSens1()
    {
        return sens1;
    }

    public void afficheRoute()
    {
        this.sens1.afficheVoie();
        System.out.println();
        this.sens2.afficheVoie();
    }

    @Override
    public String toString() {
        return "Route{" +
                "sens1=" + sens1 +
                ", sens2=" + sens2 +
                ", entreeSortie=" + entreeSortie +
                ", sortieEntree=" + sortieEntree +
                '}';
    }

    public Voie getEntreeAleatoire()
    {
        Random rand = new Random();
        int sens    = rand.nextInt(1);
        System.out.println( "indice " + sens) ;
        if( sens == 1 )
        {
            return this.sens1;
        }
        else
        {
            return this.sens2;
        }
    }
}
