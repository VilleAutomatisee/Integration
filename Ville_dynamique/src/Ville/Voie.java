package Ville;

import java.util.ArrayList;


/**
 * Created by lenzamba on 09/10/2014.
 */
public class Voie {

    private ArrayList<PositionBloc> listPositionsBlocs;
    private PositionBloc debutVoie;
    private PositionBloc finVoie;

    public Voie(int nbPositionBloc)
    {

        listPositionsBlocs = new ArrayList<PositionBloc>();

        listPositionsBlocs = this.genPositionBloc(nbPositionBloc);

    }

    // Génération de la liste chainée de taille [nbPositionBloc] PositionBloc

    private ArrayList<PositionBloc> genPositionBloc(int nbPositionBloc)
    {

        PositionBloc positionSuivante = null;

        PositionBloc positionCourante = new PositionBloc(true);

        this.listPositionsBlocs.add(positionCourante);

        for(int i = 0 ; i < nbPositionBloc ; i++)
        {
            PositionBloc positionNouvelle = new PositionBloc(false);

            positionCourante.setSuivant(positionNouvelle);

            this.listPositionsBlocs.add(positionNouvelle);

            positionCourante = positionNouvelle ;
        }

        this.finVoie = positionCourante;

        return listPositionsBlocs;
    }


    public void ajouterNouvelleVoiture(Voiture v) {

        PositionBloc debutDeVoie = getEntreeVoie();
        debutDeVoie.setVoiturePresente(v);
    }

    public PositionBloc getEntreeVoie()
    {
        return this.listPositionsBlocs.get(0);
    }

    public void connection(Voie voie2)
    {
        this.finVoie.setSuivant(voie2.getEntreeVoie());
    }

    public PositionBloc getSortieVoie() {
        return finVoie;
    }
}
