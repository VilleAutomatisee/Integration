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
            System.out.println("J'avance");
            this.positionActuelle.getSuivant().setVoiturePresente(this);
            this.positionActuelle.setVoiturePresente(null);
        }
        else
        {
            System.out.println("La position suivante est occupe");
        }

	}

	
}
