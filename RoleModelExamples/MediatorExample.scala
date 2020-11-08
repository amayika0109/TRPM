package scroll.examples
import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object MediatorExample extends App {

  class MediatorCompartment() extends Compartment {
    import Relationship._

    class Mediator() {
      var Status = false

      def registerTMRS(tmrs: TMRSColleague): Unit ={
        println( tmrs.display + "is registered to mediator")
      }

      def registerLobeto(lobeto: LobetoColleague): Unit ={
        println(lobeto.display + "is registered to mediator")
      }

      def setStatus(status: Boolean ): Unit ={
        Status = status
      }

      def getStatus(): Boolean ={
        Status
      }
    }

    class WSMediator() {
      def display(): Unit ={
        println("redirecting to mediator....")
      }
    }

    class Colleague() {

      def readyColleague(status:Boolean): Unit={
        if (status)
          println("Colleague ready...")
        else
          println("Colleague is waiting....")
      }

      def isReady(s:String): Boolean =
      {
        println( s+ " is ready for communication...")
        return true
      }
    }

    class TMRSColleague(name:String)
    {
      def display(): Unit = {
        println("All ready:  " + name)
      }
    }

    class LobetoColleague(name: String)
    {
      def display(): Unit = {
        println("All ready: "+ name)
      }
    }
  }

  new MediatorCompartment {
    var mediator = new Mediator
    var wsMediator = new WSMediator
    var temptmrs= new TMRSColleague("tmrs1")
    var templobeto= new LobetoColleague("lobeto1")
    var colleague= new Colleague
    var status=false

    wsMediator play mediator
    temptmrs play colleague
    templobeto play colleague

    +wsMediator registerTMRS temptmrs
    +wsMediator registerLobeto templobeto

    println("----------------------------------")
    println("WSMediator is communicating between TMRS and Lobeto")

    +temptmrs isReady "TMRS"
    wsMediator.display()
    status = +templobeto isReady "Lobeto"
    +wsMediator setStatus status
    +temptmrs Status status
  }
}
