import GLOOP.*;
import java.lang.*;
public class Ufospiel {
    private GLSchwenkkamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLTafel tafel,tafel2;
    private Astriod[] astriod;

    private Laserstrahl laserstrahl;
    private Ufo meinUfo;

    public Ufospiel() {
        kamera = new GLSchwenkkamera(800, 600);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/Img/Sterne.jpg");
        kamera.setzeScheitelrichtung(0, 90, 0);
        kamera.setzePosition(0, -500, 0.1);
        meinUfo = new Ufo();
        tafel = new GLTafel(220,0,230,100,100);
        tafel.setzeAutodrehung(true);
        tafel2 = new GLTafel(-220,0,230,100,100);
        tafel2.setzeAutodrehung(true);
        astriod = new Astriod[50];
        laserstrahl = new Laserstrahl(meinUfo);
        //tafel schüsse
        tafel.setzeText("Verfügbare Munition : " + laserstrahl.gibSchussAnzahl(),20);
        tafel.setzeTextur("src/Img/invisible.png");
        tafel.setzeTextfarbe(1,0,0);
        //tafel leben
        tafel2.setzeText("Verfügbare Leben : " + meinUfo.giblebenanzahl(),20);
        tafel2.setzeTextur("src/Img/invisible.png");
        tafel2.setzeTextfarbe(1,0,0);

        for (int i = 0; i < astriod.length; i++) {
            astriod[i] = new Astriod(meinUfo);

            astriod[i].verschiebe(Math.random() * 30, 0, 0);

            if (i % 4 == 3) {
                astriod[i].textur1();


            }
            if (i % 4 == 0) {
                astriod[i].textur2();


            }
            if (i % 4 == 2) {
                astriod[i].textur3();


            }
            if (i % 4 == 1) {
                astriod[i].textur4();


            }
        }
        run();

    }

    public void run() {

        while (!tastatur.esc()) {


            if (tastatur.links()) {
                meinUfo.bewegeLinks();

            }
            if (tastatur.rechts()) {
                meinUfo.bewegeRechts();

            }
            if (tastatur.unten()) {
                meinUfo.bewegeUnten();

            }
            if (tastatur.oben()) {
                meinUfo.bewegeOben();
            }

            if(tastatur.enter()){
                laserstrahl.Munition();
                tafel.setzeText("Deine Freien Schüsse: " + laserstrahl.gibSchussAnzahl(),20);
            }






            for (int i = 0; i < 50; i++) {
                astriod[i].fallen(1);
            }

            Sys.warte();

        }
        int u = 1;





    }
}
