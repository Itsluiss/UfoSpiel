import GLOOP.*;
import java.lang.*;
public class Ufo {
    private GLTorus rumpf;
    private GLKugel cockpit;
    private GLKegel fluegel1, fluegel2;
    private GLTastatur tastatur;
    int leben = 5;

    public Ufo() {
        cockpit = new GLKugel(0, 0, 20, 10);
        cockpit.setzeFarbe(64, 64, 64);
        cockpit.setzeTextur("src/Img/teller.jpg");
        rumpf = new GLTorus(0, 0, 20, 10, 6);

        rumpf.drehe(0, 0, 0);
        rumpf.setzeFarbe(0, 0, 0);
        rumpf.setzeTextur("src/Img/Teller.jpg");
        fluegel1 = new GLKegel(0, 0, 20, 20, 20);
        fluegel1.drehe(180, 0, 0);
        fluegel1.setzeTextur("src/Img/Teller.jpg");
        fluegel2 = new GLKegel(0, 0, 20, 10, 10);
        fluegel2.drehe(0, 0, 90);
        cockpit.setzeSelbstleuchten(10, 10, 10);
        fluegel1.setzeSelbstleuchten(10, 10, 10);
        fluegel2.setzeSelbstleuchten(10, 10, 10);
        rumpf.setzeSelbstleuchten(0, 0, 0);

    }

    public void bewegeLinks() {
        if (cockpit.gibX() < -380) {
        } else {
            cockpit.verschiebe(-2, 0, 0);
            rumpf.verschiebe(-2, 0, 0);
            fluegel1.verschiebe(-2, 0, 0);
            fluegel2.verschiebe(-2, 0, 0);
        }
    }

    public void bewegeRechts() {
        if (this.gibX() > 380) {
        } else {
            cockpit.verschiebe(2, 0, 0);
            rumpf.verschiebe(2, 0, 0);
            fluegel1.verschiebe(2, 0, 0);
            fluegel2.verschiebe(2, 0, 0);
        }
    }

    public void bewegeOben() {
        if (this.gibZ() > 250) {
        } else {
            cockpit.verschiebe(0, 0, 2);
            rumpf.verschiebe(0, 0, 2);
            fluegel1.verschiebe(0, 0, 2);
            fluegel2.verschiebe(0, 0, 2);
        }
    }

    public void bewegeUnten() {
        if (this.gibZ() < -250) {
        } else {
            cockpit.verschiebe(0, 0, -2);
            rumpf.verschiebe(0, 0, -2);
            fluegel1.verschiebe(0, 0, -2);
            fluegel2.verschiebe(0, 0, -2);
        }
    }


    public void explodiere() {
        leben = leben-1;
        double q = Math.random();
        for (int i = 0; i < 2000; i++) {
            rumpf.verschiebe(-q, q, q);
            rumpf.drehe(-q, q, q);
            cockpit.verschiebe(q, +q, q);
            cockpit.drehe(q, +q, q);
            fluegel1.verschiebe(-q, q, -q);
            fluegel2.verschiebe(-q, q, -q);
        }

        Sys.warte(50);
        this.Spawn();

        if (leben == 4) {
            cockpit.setzeFarbe(30, 30, 30);
            fluegel1.setzeFarbe(30, 30, 30);
            fluegel2.setzeFarbe(30, 30, 30);
            rumpf.setzeFarbe(30, 30, 30);
        }
        if (leben == 3) {
            cockpit.setzeFarbe(20, 20, 20);
            fluegel1.setzeFarbe(20, 20, 20);
            fluegel2.setzeFarbe(20, 20, 20);
            rumpf.setzeFarbe(20, 20, 20);
        }
        if (leben == 2) {
            cockpit.setzeFarbe(10, 10, 10);
            fluegel1.setzeFarbe(10, 10, 10);
            fluegel2.setzeFarbe(10, 10, 10);
            rumpf.setzeFarbe(10, 10, 10);
        }
        if (leben == 1) {
            cockpit.setzeFarbe(50, 50, 50);
            fluegel1.setzeFarbe(50, 50, 50);
            fluegel2.setzeFarbe(50, 50, 50);
            rumpf.setzeFarbe(50, 50, 50);
        }
        if (leben == 0) {
            Sys.beenden();
        }

    }


    public void Spawn() {
        cockpit.setzePosition(0, 0, 0);
        fluegel1.setzePosition(0, 0, 0);
        fluegel2.setzePosition(0, 0, 0);
        rumpf.setzePosition(0, 0, 0);


    }

    public int giblebenanzahl() {
        //gibt wieder
        return leben;

    }


        public double gibX() {
        return cockpit.gibX();

    }

    public double gibY() {
        return cockpit.gibY();

    }

    public double gibZ() {
        return cockpit.gibZ();

    }


    }


