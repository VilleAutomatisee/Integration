package Ville;

public class Voiture
{


    private PositionBloc positionActuelle;


    public Voiture (PositionBloc p)
	{
	    this.positionActuelle = p;
	}


	public void avancerVoiture ()
	{
        if(this.positionActuelle.getSuivant().getVoiturePresente() == null)
        {

            this.positionActuelle.setVoiturePresente(null);
            this.positionActuelle.getSuivant().setVoiturePresente(this);
            this.positionActuelle = this.positionActuelle.getSuivant();

        }
        else
        {
            System.out.println("La position suivante est occupe");
        }

	}

    public void afficherVoiture()
    {
        System.out.print(" o-o ");
    }

	
}
