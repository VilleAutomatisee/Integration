package Ville;

public class Voiture extends Thread
{


    public PositionBloc getPositionActuelle() {
        return positionActuelle;
    }

    private PositionBloc positionActuelle;

    public Voiture()
    {

    }

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
        positionActuelle.getSuivant().Prend(this);
        positionActuelle.Libere();
        positionActuelle = positionActuelle.getSuivant();

	}

    public void afficherVoiture()
    {
        System.out.print(" o-o ");
    }


    public void circuler(Voie voie)
    {
        while(true)
        {
            this.avancerVoiture();
        }
    }

    public void run(){
            while (!isInterrupted()) {
                synchronized (positionActuelle) {
                     try {
                         this.avancerVoiture();
                    }catch(Exception e){
                         e.printStackTrace();
                     }
                }
            }

    }

	
}
