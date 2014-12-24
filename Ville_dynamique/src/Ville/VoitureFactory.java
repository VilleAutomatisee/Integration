package Ville;

public class VoitureFactory
{
    private static VoitureFactory instance = new VoitureFactory();

    private VoitureFactory()
    {}

    public static VoitureFactory getInstance()
    {
        return instance;
    }

    public static Voiture createVoiture( String nom,PositionBloc p, int vitesse )
    {
        return new Voiture( nom, p, vitesse );
    }
}
