import GLOOP.*;
import java.lang.*;
public class Astriod{
    GLKugel astriod,astriod2,astriod3;
    
    private Ufo dasUfo;
    
    public Astriod(Ufo pUfo){
        int x = (int) (Math.random()*3000-2900);
        int y = (int) (Math.random()*3000-2900);
        int z = (int) (Math.random()*3000-1500);
        int k = (int) (Math.random()*120);
        astriod=new GLKugel(x,y,z,k );
        astriod.setzeSkalierung (Math.random()*1.5,Math.random()+0.3,Math.random()+0.3);
        
        dasUfo = pUfo;
        astriod.setzeSelbstleuchten(1,1,1);
    }
    public void textur1(){
        astriod.setzeTextur("src/Img/Pommes.jpg");
        
        
    }
    public void textur2(){
        astriod.setzeTextur("src/Img/Asteriod.jpg");
        
        
    }
     public void textur3(){
        astriod.setzeTextur("src/Img/Reis.jpg");
        
        
    }
     public void textur4(){
        astriod.setzeTextur("src/Img/Kaese.jpg");
        
        
    }
    public void fallen(double g){
        astriod.verschiebe(0,-g,0);
        astriod.drehe(0.1,0.1,0.1);
        if(astriod.gibY()<-300)this.zuruecksetzen();
        if(this.getroffen())dasUfo.explodiere();
    }
    private boolean getroffen(){
        double abstand = Math.sqrt(
        Math.pow( astriod.gibX()-dasUfo.gibX(), 2 ) + 
        Math.pow( astriod.gibY()-dasUfo.gibY(), 2 ) + 
        Math.pow( astriod.gibZ()-dasUfo.gibZ(), 2 ) 
              );
        if ( abstand<70) return true;
        else return false;
        
    }
    private void zuruecksetzen(){
        int x = (int) (Math.random()*3000-1500);
        int z = (int) (Math.random()*3000-1500);
        int p = (int) (Math.random()*3000-800);
        astriod.setzePosition(x ,p,z);
        astriod.setzeSkalierung(1,Math.random()+0.3,Math.random()+0.3);
        
    }
    public void verschiebe(double a,double b,double c){
    astriod.verschiebe(a,b,c);
}
}
