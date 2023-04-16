import GLOOP.*;
import java.lang.*;

public class Laserstrahl {
    public GLZylinder Laser;
    public Ufo DasUfo;

    int schusse = 5 ;

    public Laserstrahl (Ufo DasUfo) {
        this.DasUfo = DasUfo;
        Laser = new GLZylinder(DasUfo.gibX(), DasUfo.gibY(), DasUfo.gibZ(), 4, 1000);
        Laser.drehe(90, 0, 0);
        Laser.setzeFarbe(0, 7, 1);
        Laser.setzeSichtbarkeit(false);
    }






        public void Munition () {
            if (schusse == 0) {

                Laser.setzePosition(2000, 2000, 2000);
                Laser.setzeSichtbarkeit(false);
            } else {
                Laser.setzePosition(DasUfo.gibX(), DasUfo.gibY() + 500, DasUfo.gibZ());
                Laser.setzeSichtbarkeit(true);
                Sys.warte(200);
                Laser.setzePosition(3000,3000,-300);
                schusse = schusse-1;

            }


        }
        public int gibSchussAnzahl(){
        //gibt wieder
        return schusse;
        }
    }



