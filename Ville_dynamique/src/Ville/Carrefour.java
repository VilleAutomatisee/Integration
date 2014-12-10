package Ville;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leite_2 on 09/10/2014.
 */
public class Carrefour
{


    private List <Interface> interfaces ;

    public Carrefour( List<Route> routes )
    {

        this.interfaces = new ArrayList<Interface>() ;

        // Création des interfaces à partir du nombre de routes connectées au carrefour

        for(int i = 0 ; i< routes.size() ; i++)
        {
            this.interfaces.add(new Interface(new PositionBloc(), new PositionBloc()));
        }

        // Création de la cohésion des différents bloc dans les interfaces

        for(int i = 0 ; i< this.interfaces.size() ; i++)
        {

                this.interfaces.get(i).getSortie().addSuivant(this.interfaces.get(i).getEntree());

        }

        // Attention a bien connecter les SOrtieEntree des routes dans la ville
        for( int i = 0 ; i <= routes.size(); i++ )
        {
           routes.get(i).getEntreeSortie().connectRoute(this.interfaces.get(i));
        }

    }
/*
    private void genInterfacesCarrefour()
    {
        PositionBloc positionNordOuest  = new PositionBloc ();
        PositionBloc positionSudOuest   = new PositionBloc ();
        PositionBloc positionNordEst    = new PositionBloc ();
        PositionBloc positionSudEst     = new PositionBloc ();

        positionNordOuest.addSuivant(positionNordEst);
        positionNordEst.addSuivant(positionSudEst);
        positionSudEst.addSuivant(positionSudOuest);
        positionSudOuest.addSuivant(positionNordOuest);

        this.faceEst                    = new Interface( positionNordEst     , positionSudEst );
        this.faceNord                   = new Interface( positionNordOuest   , positionNordEst );
        this.faceOuest                  = new Interface( positionNordOuest   , positionSudOuest );
        this.faceSud                    = new Interface( positionSudOuest    , positionSudEst );
    }

    public Interface getFaceOuest()
    {
        return this.faceOuest;
    }

    public Interface getFaceEst()
    {
        return this.faceEst;
    }

    public Interface getFaceNorth()
    {
        return this.faceNord;
    }

    public Interface getFaceSouth()
    {
        return this.faceSud;
    }*/
}
