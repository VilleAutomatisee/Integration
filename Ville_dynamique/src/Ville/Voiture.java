package Ville;

public class Voiture
{


    public PositionBloc getPositionActuelle() {
        return positionActuelle;
    }

    private PositionBloc positionActuelle;


    public Voiture (PositionBloc p)
	{

        if(p.getVoiturePresente() == null)
        {
            this.positionActuelle = p;
            this.positionActuelle.setVoiturePresente(this);
        }
        else
        {
            p.getVoiturePresente().avancerVoiture();
            this.positionActuelle = p;
            this.positionActuelle.setVoiturePresente(this);

        }

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
            this.positionActuelle.getSuivant().getVoiturePresente().avancerVoiture();

            this.positionActuelle.setVoiturePresente(null);
            this.positionActuelle.getSuivant().setVoiturePresente(this);
            this.positionActuelle = this.positionActuelle.getSuivant();
        }

	}

    public void afficherVoiture()
    {
        System.out.print(" o-o ");
    }

	
}
