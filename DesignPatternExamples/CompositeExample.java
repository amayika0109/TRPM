import java.util.ArrayList; 
import java.util.List; 
  

public class CompositeExample {
    public static void main (String[] args) 
    { 
    	DieObj die1 = new DieObj(100, "kb: Design File, Type: ", "PNG"); 
    	DieObj die2 = new DieObj(101, "kb: Role File, Type: ", "JPG"); 
        Lot fileDirectory = new Lot(); 
        fileDirectory.addDie(die1); 
        fileDirectory.addDie(die2); 
           
        Wafer wafer1 = new Wafer(2000, "mb : DP Directory, ", "Design Patterns"); 
        Wafer wafer2 = new Wafer(2010, "mb : Role Directory, ", "Role models");           
        Lot fileDirectory2 = new Lot(); 
        fileDirectory2.addDie(wafer1); 
        fileDirectory2.addDie(wafer2); 
       
        Lot rootdirectory = new Lot(); 
        rootdirectory.addDie(fileDirectory); 
        rootdirectory.addDie(fileDirectory2); 
        rootdirectory.showDieDetails(); 
    } 

}

interface Die 
{ 
    public void showDieDetails(); 
} 
  
class DieObj implements Die 
{ 
    private String name; 
    private long dieId; 
    private String position; 
      
    public DieObj(long dieId, String name, String position) 
    { 
        this.dieId = dieId; 
        this.name = name; 
        this.position = position; 
    } 
      
    @Override
    public void showDieDetails()  
    { 
        System.out.println(dieId+" " +name+ " " + position ); 
    } 
} 
  
class Wafer implements Die 
{ 
    private String name; 
    private long waferID; 
    private String position; 
   
    public Wafer(long waferID, String name, String position) 
    { 
        this.waferID = waferID; 
        this.name = name; 
        this.position = position; 
    } 
       
    @Override
    public void showDieDetails()  
    { 
        System.out.println(waferID+" " +name+ " " + position ); 
    } 
} 
  
  
class Lot implements Die 
{ 
    private List<Die> dieList = new ArrayList<Die>(); 
        
    @Override
    public void showDieDetails()  
    { 
        for(Die die:dieList) 
        { 
            die.showDieDetails(); 
        } 
    } 
        
    public void addDie(Die die) 
    { 
    	dieList.add(die); 
    } 
        
    public void removeDie(Die die) 
    { 
    	dieList.remove(die); 
    } 
} 