package Ville;

import java.util.ArrayList;


/**
 * Created by lenzamba on 09/10/2014.
 */
public class Voie {

    private String nom;
    private ArrayList<PositionBloc> listPositionsBlocs;


    public Voie(String nom,int nbPositionBloc)
    {
        this.nom                        = nom;
        this.listPositionsBlocs         = new ArrayList<PositionBloc>();

        this.genPositionBloc(nbPositionBloc);

    }

    // Génération de la liste chainée de taille [nbPositionBloc] PositionBloc

    private void genPositionBloc(int nbPositionBloc)
    {

        PositionBloc positionCourante = new PositionBloc(this.nom , 1 ,true );

        this.listPositionsBlocs.add(positionCourante);

        for(int i = 1 ; i < nbPositionBloc +1 ; i++ )
        {
            PositionBloc positionNouvelle = new PositionBloc( nom , i , false);

            positionCourante.addSuivant(positionNouvelle);

            this.listPositionsBlocs.add(positionNouvelle);

            positionCourante = positionNouvelle ;
        }
    }




    public PositionBloc getBlockAleatoire(){

        int b = (int)Math.random()*this.listPositionsBlocs.size();
        return this.listPositionsBlocs.get(b);
    }







    public void ajouterNouvelleVoiture( Voiture v )
    {
        PositionBloc debutDeVoie = getEntreeVoie();
        debutDeVoie.setVoiturePresente(v);

        System.out.println( "Voiture ajoutée." );
    }







    public PositionBloc getPosition(int i)
    {
        return this.listPositionsBlocs.get(i);
    }







    public PositionBloc getEntreeVoie()
    {
        return this.listPositionsBlocs.get(0);
    }






    public PositionBloc getSortieVoie()
    {
        return this.listPositionsBlocs.get(this.listPositionsBlocs.size()-1);
    }









    public void connectionSortie(Voie voie2)
    {
        this.getSortieVoie().addSuivant(voie2.getEntreeVoie());
    }



    public void connectionEntree(Voie voie2)
    {
        this.getEntreeVoie().addSuivant(voie2.getSortieVoie());
    }





    public void afficheVoie()
    {
       for (int i = 0 ; i < listPositionsBlocs.size() ; i++)
       {
           if(listPositionsBlocs.get(i).getVoiturePresente() == null)
           {
               System.out.print(" - ");
           }
           else
           {
               listPositionsBlocs.get(i).getVoiturePresente().afficherVoiture();
           }
       }
        System.out.println();
    }







    /**
     * On fait circuler toutes les voitures présents sur cette voie.
     */
    /*public void circuler()
    {*/
        /*// pour chaque voiture présente sur la voie.
        int i;
        PositionBloc tmp = null ;

        boolean a = true;
        while( a )
        {
            // toute la voie.
            for( i = this.listPositionsBlocs.size()-1; i >= 0; i-- )
            {
                tmp = this.listPositionsBlocs.get( i );
                if( tmp != null )
                {
                    Voiture voiture = tmp.getVoiturePresente();
                    if( voiture != null )
                    {
                        voiture.avancerVoiture();

                        System.out.println( "Avance" );
                    }


                }
            }


            this.afficheVoie();
        }*/



    /*}*/

    @Override
    public String toString() {
        return "Voie{" +
                "nom='" + nom + '\'' +
                ", listPositionsBlocs=" + listPositionsBlocs +
                ", debutVoie=" + this.getEntreeVoie() +
                ", finVoie=" + this.getSortieVoie() +
                '}';
    }
}
