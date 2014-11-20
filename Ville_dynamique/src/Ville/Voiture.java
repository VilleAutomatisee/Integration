package Ville;

import java.util.ArrayList;

public class Voiture extends Thread
{
    private String nom;
    private PositionBloc positionActuelle;
    private int vitesse;

    public Voiture()
    {

    }

    public Voiture(String nom,PositionBloc p, int vitesse)
	{
        System.out.println( "Voiture "+nom+" ajoutée." );
        this.nom = nom;
        this.positionActuelle = p;
        this.positionActuelle.setVoiturePresente(this);
        this.vitesse = vitesse;
	}
    public PositionBloc getPositionActuelle() {
        return positionActuelle;
    }
    public String getNom() { return nom; }
	public boolean avancerVoiture ()
	{
        PositionBloc positionsuivante = positionActuelle.getSuivant();
        if ( positionsuivante==null  ) {
            System.out.println("A la fin");
            return false;
        }
        System.out.println( "Avancer voiture "+nom+" je suis en "+positionActuelle+" je vais en "+positionActuelle.getSuivant());

        positionActuelle.getSuivant().Prend(this);
        positionActuelle.Libere();
        positionActuelle = positionActuelle.getSuivant();
        return true;
	}

    public void afficherVoiture()
    {
        System.out.print(" o-o ");
    }

    public void run()
    {
        System.out.println( "Run voiture thread\n" );
        boolean fin=false;
        while ( !fin ) {
                 try {
                    fin= !this.avancerVoiture();
                    sleep(1000/vitesse);
                }catch(Exception e){
                     e.printStackTrace();
                 }

        }

    }
}
