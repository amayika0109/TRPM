import java.io.*;
public class MediatorExample2{
 
    public static void main(String args[])  
    { 
  
        WSMediator2 wsMediator = new WSMediator2(); 
        LobetoColleague2 lobeto = new LobetoColleague2(wsMediator); 
        LotRetestColleague2 lotretest = new LotRetestColleague2(wsMediator); 
        wsMediator.registerAppColleague(lobeto); 
        wsMediator.registerAppColleague(lotretest);
        lobeto.getReady(); 
        lotretest.readyColleagues(); 
        lobeto.readyColleagues(); 
    } 

}

interface  IMediator2{
    public void registerAppColleague(Colleague2 colleague1);
    public boolean isOk(); 
    public void setStatus(boolean status);
}

class WSMediator2 implements IMediator2{
    private Colleague2 colleague;
    public boolean ready;
    
    public void registerAppColleague(Colleague2 colleague1)
    {
        this.colleague = colleague1;
    }
    
    public boolean isOk()
    {
        return ready;
    }
    
    public void setStatus(boolean status)
    {
        ready = status;
    }
    
}

interface Colleague2{
    void readyColleagues();
}

class TMRSColleague2 implements Colleague2{
    private WSMediator2 wsmediator;
    
    public TMRSColleague2(WSMediator2 mediator){
        this.wsmediator = mediator;
        
    }
    public void readyColleagues(){
        System.out.println("TMRS is ready to start"); 
    }
    
    public void getReady(){
        System.out.println("TMTRS is Ready."); 
    }

}

class LobetoColleague2 implements Colleague2{
    private WSMediator2 mediator1;   
    
    public LobetoColleague2(WSMediator2 mediator){
        this.mediator1 = mediator;
        mediator1.setStatus(true);
        
    }
    public void readyColleagues(){
        System.out.println("Lobeto is ready to start and receive"); 
        mediator1.setStatus(true); 
    }
    
    public void getReady(){
        System.out.println("Lobeto is Ready to trigger."); 
    }

}

class LotRetestColleague2 implements Colleague2{
    private WSMediator2 mediator1;   
    
    public LotRetestColleague2(WSMediator2 mediator){
        this.mediator1 = mediator;
        mediator1.setStatus(true);
        
    }
    public void readyColleagues(){
        System.out.println("LotRetest is ready to receive"); 
        mediator1.setStatus(true); 
    }
    

}

