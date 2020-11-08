import scroll.internal.Compartment

object BridgeExample extends App {

  case class BridgeCompartment() extends Compartment {

    var pbin=new PBin
    var fbin=new FBin

    //Bin can play the role of hard bin or soft bin
    class Bin{
      def check(s:String): Unit ={
        println(s+" needs to be created...")
      }
    }

    class HBin
    {
      def create(pf: PFBin): Unit ={
        println("HBin is creating...")
        var s= "Hard Bin"
        pf.check(s)

        //HBin can be PBin
        pf play pbin
        +pf getPF s

        //HBin can be FBin
        /*
        pf play fbin
        +pf work s
        */
      }
    }

    class SBin
    {
      def create(pf: PFBin): Unit ={
        println("SBin is creating...")
        var s= "Soft Bin"
        pf.check(s)

        // SBin can be PBin
        /*
        pf play pbin
        +pf work s
        */

        //SBin can be FBin
        pf play fbin
        +pf getPF s
      }
    }

    class PFBin
    {
      def check(s:String): Unit ={
        println(s+" is pass/fail bin?")
      }
    }

    class PBin
    {
      def getPF(s:String): Unit ={
        println(s+" & Pass Bin...")
      }
    }

    class FBin{
      def getPF(s:String): Unit ={
        println(s+" & Fail Bin...")
      }
    }
  }

  new BridgeCompartment{
    var b1=new Bin
    var b2 = new Bin
    var h1 = new HBin
    var s1 = new SBin
    var pf1=new PFBin
    var pf2=new PFBin
    var s="Hard Bin"

    //Here bin is playing the role of HBin and HBin is created
    b1 play h1
    b1.check(s)
    +b1 create pf1

    println("------------------")
    //Here bin is playing the role of SBin and SBin is created
    s="Soft Bin"
    b2 play s1
    b2.check(s)
    +b2 create pf2
  }
}