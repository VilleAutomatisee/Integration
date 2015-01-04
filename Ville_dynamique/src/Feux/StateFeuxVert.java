package Feux;

public class StateFeuxVert implements FeuxState
{
    @Override
    public void couleurSuivante( Feux feux )
    {
        feux.setState( new StateFeuxOrange() );
    }

    @Override
    public int getDureeCouleur( Feux feux )
    {
        return feux.getDureeFeuxVert();
    }
}
