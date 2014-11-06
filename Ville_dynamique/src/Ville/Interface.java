package Ville;

/**
 * Created by lenzamba on 09/10/2014.
 */
public class Interface {

    private PositionBloc entree ;
    private PositionBloc sortie ;

    public Interface( PositionBloc entree, PositionBloc sortie )
    {
        this.entree = entree;
        this.sortie = sortie;
    }

    public PositionBloc getEntree() {
        return this.entree;
    }

    public PositionBloc getSortie() {
        return this.sortie;
    }

    public void connectRoute(Interface interfaceEntreeSortie)
    {
        interfaceEntreeSortie.getSortie().setSuivant( this.getEntree() );
        this.getSortie().setSuivant( interfaceEntreeSortie.getEntree() );
    }
}
