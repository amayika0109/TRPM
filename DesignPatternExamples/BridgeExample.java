import java.io.*;
public class BridgeExample {
  
    public static void main(String args[])  
    { 
        Bin b1 = new HBin(new PBin()); 
        b1.hs(); 
        System.out.print("--------------");
        Bin b2 = new HBin( new FBin()); 
        b2.hs(); 
        System.out.print("--------");
        Bin b3 = new SBin( new PBin()); 
        b3.hs(); 
        System.out.print("--------");
        Bin b4 = new SBin( new FBin()); 
        b4.hs(); 
        
    } 


}
abstract class Bin { 
    protected PFBin pf; 
  
    protected Bin(PFBin pf) 
    { 
        this.pf = pf; 
    } 
    abstract public void hs(); 
} 

class HBin extends Bin { 
    public HBin(PFBin pf) 
    { 
        super(pf); 
    } 
  
    @Override
    public void hs() 
    { 
        System.out.print("Hard Bin "); 
        System.out.print(" And");
        pf.work(); 
    } 
} 

class SBin extends Bin { 
    public SBin(PFBin pf1) 
    { 
        super(pf1); 
    } 
  
    @Override
    public void hs() 
    { 
        System.out.print("Soft Bin "); 
        System.out.print(" And");
        pf.work(); 
    } 
} 

interface PFBin 
{ 
    abstract public void work(); 
} 
  

class PBin implements PFBin { 
    @Override
    public void work() 
    { 
        System.out.print("Pass Bin"); 
    } 
} 
  

class FBin implements PFBin { 
    @Override
    public void work() 
    { 
        System.out.print(" And"); 
        System.out.println(" Fail Bin."); 
    } 
} 
