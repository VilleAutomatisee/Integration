package Feux;

import Ville.PositionBloc;

public interface FeuxState
{
    public void couleurSuivante( Feux feux );
    public int getDureeCouleur( Feux feux );
}
