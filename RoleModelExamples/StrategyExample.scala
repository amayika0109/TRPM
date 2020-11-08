import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object StrategyExample extends App {

  case class StrategyCompartment() extends Compartment {
    import Relationship._

    class AlgorithmStrategy{
      def calculate: Unit ={
        println("Setting algorithm to calculate :")
      }
    }

    // Algorithm for Static module
    class StaticAlgorithmStrategy{
      def check(s:String): Unit = {
        println("Static Algorithm for :" + s )
      }
    }

    // Algorithm for Historic module
    class HistoricAlgorithmStrategy{
      def check(s:String): Unit = {
        println("Historic Algorithm for :" + s )
      }
    }

    class ApplicationContext(ctx:String) {
      var context= ctx
      println("Check Algorithm for :"  + context)
    }
  }

  new StrategyCompartment {
    var algorithmStrategy = new AlgorithmStrategy
    var staticAlgorithmStrategy = new StaticAlgorithmStrategy
    var historicAlgorithmStrategy = new HistoricAlgorithmStrategy

    println("----------------------------" )
    var applicationContext3 = new ApplicationContext("StaticModule")
    algorithmStrategy.calculate
    algorithmStrategy play staticAlgorithmStrategy
    +algorithmStrategy check applicationContext3.context

    println("----------------------------" )
    var applicationContext1 = new ApplicationContext("HistoricModule")
    algorithmStrategy.calculate
    algorithmStrategy play historicAlgorithmStrategy
    +algorithmStrategy check applicationContext1.context

    println("----------------------------" )
    var applicationContext2 = new ApplicationContext("StaticModule")
    algorithmStrategy.calculate
    algorithmStrategy play staticAlgorithmStrategy
    +algorithmStrategy check applicationContext2.context
  }

}

