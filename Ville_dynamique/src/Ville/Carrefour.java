package Ville;

/**
 * Created by leite_2 on 09/10/2014.
 */
public class Carrefour {

    private Interface faceSud;
    private Interface faceNord;
    private Interface faceEst;
    private Interface faceOuest;

    public Carrefour()
    {
        this.genInterfacesCarrefour();
    }

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

        this.faceEst        = new Interface(positionNordEst     , positionSudEst);
        this.faceNord       = new Interface(positionNordOuest   , positionNordEst);
        this.faceOuest      = new Interface(positionNordOuest   , positionSudOuest);
        this.faceSud        = new Interface(positionSudOuest    , positionSudEst);
    }

    public Interface getFaceOuest() {
        return this.faceOuest;
    }

    public Interface getFaceEst() {
        return this.faceEst;
    }

    public Interface getFaceNorth() {
        return this.faceNord;
    }

    public Interface getFaceSouth() {
        return this.faceSud;
    }
}
