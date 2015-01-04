package Feux;

public class StateFeuxRouge implements FeuxState
{
    @Override
    public void couleurSuivante( Feux feux )
    {
        feux.setState( new StateFeuxVert() );
    }

    @Override
    public int getDureeCouleur( Feux feux )
    {
        return feux.getDureeFeuxRouge();
    }
}
