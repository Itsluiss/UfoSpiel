import GLOOP.*;
import java.lang.*;
public class Ufo{
    private GLTorus rumpf; 
    private GLKugel cockpit;
    private GLKegel fluegel1, fluegel2;
    private GLTastatur tastatur;

    public Ufo(){
        cockpit = new GLKugel (0,0,20,10);
        cockpit.setzeFarbe(64,64,64);
        cockpit.setzeTextur("src/Img/teller.jpg");
        rumpf = new GLTorus(0,0,20,10,6);
        
        rumpf.drehe(0,0,0);
        rumpf.setzeFarbe(0,0,0);
        rumpf.setzeTextur("src/Img/Teller.jpg");
        fluegel1 = new GLKegel (0,0,20,20,20);
        fluegel1.drehe(180,0,0);
        fluegel1.setzeTextur("src/Img/Teller.jpg");
        fluegel2 = new GLKegel (0,0,20,10,10);
        fluegel2.drehe(0,0,90);
       cockpit.setzeSelbstleuchten(10,10,10);
       fluegel1.setzeSelbstleuchten(10,10,10);
       fluegel2.setzeSelbstleuchten(10,10,10);
       rumpf.setzeSelbstleuchten(0,0,0);
}

    public void bewegeLinks(){
        if(cockpit.gibX()<-380){
        }
        else{
            cockpit.verschiebe(-2,0,0);
            rumpf.verschiebe(-2,0,0);
            fluegel1.verschiebe(-2,0,0);
            fluegel2.verschiebe(-2,0,0);
        }
    }

    public void bewegeRechts(){       
        if(this.gibX()>380){
        }
        else{
            cockpit.verschiebe(2,0,0);
            rumpf.verschiebe(2,0,0);
            fluegel1.verschiebe(2,0,0);
            fluegel2.verschiebe(2,0,0);
        }
    }
    public void bewegeOben(){       
        if(this.gibZ()>250){
        }
        else{
            cockpit.verschiebe(0,0,2);
            rumpf.verschiebe(0,0,2);
            fluegel1.verschiebe(0,0,2);
            fluegel2.verschiebe(0,0,2);
        }
    }
    public void bewegeUnten(){       
        if(this.gibZ()<-250){
        }
        else{
            cockpit.verschiebe(0,0,-2);
            rumpf.verschiebe(0,0,-2);
            fluegel1.verschiebe(0,0,-2);
            fluegel2.verschiebe(0,0,-2);
        }
    }

    
    
    
    
    
    public void explodiere(){
    double q = Math.random();
    for (int i=0; i<2000;i++){
        rumpf.verschiebe (-q,q,q);
        rumpf.drehe ( -q,q,q);
        cockpit.verschiebe(q,+q,q);
        cockpit.drehe(q,+q,q);
        fluegel1.verschiebe (-q,q,-q);
        fluegel2.verschiebe (-q,q,-q);
        Sys.warte(10);
    
    
    
    
    }
    Sys.beenden();
    }

    public double gibX(){
        return cockpit.gibX();

    }
    public double gibY(){
        return cockpit.gibY();

    }
    public double gibZ(){
        return cockpit.gibZ();

    }
    

}