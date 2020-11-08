import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object StrategyExample2 extends App {

  case class StrategyCompartment() extends Compartment {
    import Relationship._

    class AlgorithmStrategy{
      def calculate: Unit ={
        println("Setting algorithm to calculate")
      }
    }

    // Algorithm for Static module
    class StaticAlgorithm{
      def checkModule(s:String): Unit = {
        println("Static Algorithm for :" + s )
      }
      def addsub(n1:Int, n2: Int): Unit = {
        var n = n1 + n2
        println("Addition of numbers is :" + n )
      }
    }

    // Algorithm for Historic module
    class HistoricAlgorithm{
      def checkModule(s:String): Unit = {
        println("Historic Algorithm for :" + s )
      }

      def addsub(n1:Int, n2: Int): Unit = {
        var n = n1 - n2
        println("Difference of numbers is :" + n )
      }
    }

    class ApplicationContext(ctx:String) {
      var context= ctx
      println("Check Algorithm for :"  + context)
    }
  }

  var n1= 30
  var n2= 10
  new StrategyCompartment {
    var algorithmStrategy = new AlgorithmStrategy
    var staticAlgorithmStrategy = new StaticAlgorithm
    var historicAlgorithmStrategy = new HistoricAlgorithm

    println("----------------------------" )
    var applicationContext = new ApplicationContext("StaticModule")
    algorithmStrategy.calculate
    algorithmStrategy play staticAlgorithmStrategy
    +algorithmStrategy checkModule applicationContext.context
    +algorithmStrategy addsub(n1,n2)
  }
  new StrategyCompartment {
    var algorithmStrategy = new AlgorithmStrategy
    var staticAlgorithmStrategy = new StaticAlgorithm
    var historicAlgorithmStrategy = new HistoricAlgorithm


    println("----------------------------" )
    var applicationContext = new ApplicationContext("StaticModule")
    algorithmStrategy.calculate
    algorithmStrategy play staticAlgorithmStrategy
    +algorithmStrategy checkModule applicationContext.context
    +algorithmStrategy addsub(n1,n2)
  }

  new StrategyCompartment {
    var algorithmStrategy = new AlgorithmStrategy
    var staticAlgorithmStrategy = new StaticAlgorithm
    var historicAlgorithmStrategy = new HistoricAlgorithm

    println("----------------------------" )
    var applicationContext = new ApplicationContext("HistoricModule")
    algorithmStrategy.calculate
    algorithmStrategy play historicAlgorithmStrategy
    +algorithmStrategy checkModule applicationContext.context
    +algorithmStrategy addsub(n1,n2)
  }
  new StrategyCompartment {
    var algorithmStrategy = new AlgorithmStrategy
    var staticAlgorithmStrategy = new StaticAlgorithm
    var historicAlgorithmStrategy = new HistoricAlgorithm

    println("----------------------------" )
    var applicationContext1 = new ApplicationContext("HistoricModule")
    algorithmStrategy.calculate
    algorithmStrategy play staticAlgorithmStrategy
    +algorithmStrategy checkModule applicationContext1.context
    +algorithmStrategy addsub(n1,n2)
  }




}

