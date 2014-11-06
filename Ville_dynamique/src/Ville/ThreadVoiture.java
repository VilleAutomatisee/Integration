package Ville;

/**
 * Created by magharbi on 06/11/2014.
 */
public class ThreadVoiture extends Thread {

    private Voiture v;
    private Voie voie;

    public ThreadVoiture(Voiture v,Voie voie) {
        this.v = v;
        this.voie=voie;
    }

    @Override
    public void run(){

        synchronized (v.getPositionActuelle()) {

            try {
                v.circuler(voie);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
