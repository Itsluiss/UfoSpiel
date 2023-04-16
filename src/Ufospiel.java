import GLOOP.*;
import java.lang.*; 
public class Ufospiel{
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;

    private Astriod[] astriod;
    
    
    private Ufo meinUfo;
    
    public Ufospiel(){
        kamera = new GLKamera(800,600);         
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/Img/Sterne.jpg");
        kamera.setzeScheitelrichtung(0,90,0);
        kamera.setzePosition(0,-500,0.1);
        meinUfo =new Ufo();
        
        astriod=new Astriod[50];
        
       
        
        
        
        
        
       
        
        
        for (int i=0; i<astriod.length ; i++ ){ 
          astriod[i]=new Astriod (meinUfo);
          
          astriod[i].verschiebe(Math.random()*30,0,0);
          
          if(i%4==3){
              astriod[i].textur1();
              
              
            }
          if(i%4==0){
              astriod[i].textur2();
              
              
            }
          if(i%4==2){
              astriod[i].textur3();
              
              
            }
                   if(i%4==1){
              astriod[i].textur4();
              
              
            }
        }
       run();
       ;
    }
    public void run (){
        
        while(!tastatur.enter()){ 
            
            if(tastatur.links()){
                meinUfo.bewegeLinks();

            }
            if(tastatur.rechts ()){
                meinUfo.bewegeRechts();
            
            }
            if(tastatur.unten ()){
                meinUfo.bewegeUnten();

            }
            if(tastatur.oben ()){
                meinUfo.bewegeOben();

            }
            
            
            
            
            for(int i=0;i<50;i++){
                astriod[i].fallen(1);
            }
            
            Sys.warte();
        
        }
        int u = 1;
       
            
        
    }
}