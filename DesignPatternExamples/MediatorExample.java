public class MediatorExample{
 
    public static void main(String args[])  
    { 
  
        WSMediator wsMediator = new WSMediator(); 
        LobetoColleague lobeto = new LobetoColleague(wsMediator); 
        LotRetestColleague lotretest = new LotRetestColleague(wsMediator); 
        wsMediator.registerAppColleague(lobeto); 
        wsMediator.registerAppColleague(lotretest);
        lobeto.getReady(); 
        lotretest.readyColleagues(); 
        lobeto.readyColleagues(); 
    } 

}

interface  IMediator{
    public void registerAppColleague(Colleague colleague1);
    public boolean isOk(); 
    public void setStatus(boolean status);
}

class WSMediator implements IMediator{
    private Colleague colleague;
    public boolean ready;
    
    public void registerAppColleague(Colleague colleague1)
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

interface Colleague{
    void readyColleagues();
}

class TMRSColleague implements Colleague{
    private WSMediator wsmediator;
    
    public TMRSColleague(WSMediator mediator){
        this.wsmediator = mediator;
        
    }
    public void readyColleagues(){
        System.out.println("TMRS is ready to start"); 
    }
    
    public void getReady(){
        System.out.println("TMTRS is Ready."); 
    }

}

class LobetoColleague implements Colleague{
    private WSMediator mediator1;   
    
    public LobetoColleague(WSMediator mediator){
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

class LotRetestColleague implements Colleague{
    private WSMediator mediator1;   
    
    public LotRetestColleague(WSMediator mediator){
        this.mediator1 = mediator;
        mediator1.setStatus(true);
        
    }
    public void readyColleagues(){
        System.out.println("LotRetest is ready to receive"); 
        mediator1.setStatus(true); 
    }
    

}

