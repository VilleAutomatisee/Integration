package Feux;

import Ville.PositionBloc;

public class StateFeuxOrange implements FeuxState
{
    @Override
    public void couleurSuivante( Feux feux )
    {
        feux.setState( new StateFeuxRouge() );
    }

    @Override
    public int getDureeCouleur( Feux feux )
    {
        return feux.getDureeFeuxOrange();
    }
}
