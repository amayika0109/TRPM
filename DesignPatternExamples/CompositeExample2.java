import java.util.ArrayList; 
import java.util.List;

public class CompositeExample2 {
    public static void main(String[] args) {
    	Lot2 lot = new Wafer2("Lot", "WaferList");

    	Lot2 w1 = new Wafer2("Wafer 1", "Wafer1 id");
    	Lot2 w2 = new Wafer2("Wafer 2", "Wafer2 id");
    	Lot2 d1 = new Die2("Die 100", "Die100 id");
    	        
    	lot.add(w1);
    	lot.add(w2);
    	lot.add(d1);

    	w1.add(new Die2("Die 11", "Die11 id"));
    	w1.add(new Die2("Die 12", "Die12 id"));
    	        
    	Lot2 w3 = new Wafer2("Wafer 3", "Wafer3 id");
    	Lot2 d2 = new Die2("Die 21", "Die21 id");       
    	        
    	w2.add(d2);
    	w2.add(w3);

    	w3.add(new Die2("Die 31", "Die31 id"));
    	w3.add(new Die2("Die 32", "Die32 id"));
    	        
    	lot.displayMenu();
    }

}

abstract class Lot2 {

    private String name;
    private String url;

    Lot2(String name1, String url1) {
    	this.name = name1;
    	this.url = url1;
    }
    
    public String getName() {
    	return this.name;
    }
    public void setName(String name1) {
    	this.name = name1;
    }
    
    public String getUrl() {
    	return this.url;
    }
    public void setUrl(String url1) {
    	this.url = url1;
    }
    
    public void add(Lot2 component) {
        throw new UnsupportedOperationException();
    }

    public abstract void displayMenu();  
}

class Die2 extends Lot2 {

    public Die2(String name, String url) {
        super(name, url);
    }

    @Override
    public void displayMenu() {
        System.out.println(getName() + " : " + getUrl());
    }       
}

class Wafer2 extends Lot2 {

    List<Lot2> subMenus = new ArrayList<>();

    public Wafer2(String name, String url) {
        super(name, url);
    }
    
    @Override
    public void add(Lot2 lotComponent) {
        this.subMenus.add(lotComponent);
    }

    @Override
    public void displayMenu() {
        System.out.println(getName() + " : " + getUrl() + "\n");
        this.subMenus.forEach(Lot2::displayMenu);
    }
}