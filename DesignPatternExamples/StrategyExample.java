import java.io.*;
import java.text.DecimalFormat;

public class StrategyExample {
	  
    public static void main(String args[])  
    {
    	ApplicationContext cal = new ApplicationContext(30, 15);
    	cal.check(new StaticAlgorithmStrategy());
    	cal.check(new HistoricAlgorithmStrategy());    	
    }

}

interface AlgorithmStrategy {

	public void addsub(int n1, int n2);
}

class StaticAlgorithmStrategy implements AlgorithmStrategy {
	
	public StaticAlgorithmStrategy(){}
	//Add the numbers
	@Override
	public void addsub(int n1, int n2) {
		int add = n1 + n2 ;
		System.out.println(n1  + n2  +" is the added value");
	}

}

class HistoricAlgorithmStrategy implements AlgorithmStrategy {

	public HistoricAlgorithmStrategy(){}
	//Substract the numbers
	@Override
	public void addsub(int n1, int n2) {
		int sub = n1 - n2 ;
		System.out.println(sub + " is the substracted value");
	}

}

class ApplicationContext {
	int n1; int n2;
	
	public ApplicationContext(int n11, int n22){
		this.n1 = n11;
		this.n2 = n22;	
	}
	
	public void check(AlgorithmStrategy algoMethod){
		algoMethod.addsub(n1, n2);
	}
}





