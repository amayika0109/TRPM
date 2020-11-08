import scroll.internal.Compartment

object BridgeExample2 extends App {

  case class BridgeCompartment() extends Compartment {

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
      }
    }

    class SBin
    {
      def create(pf: PFBin): Unit ={
        println("SBin is creating...")
        var s= "Soft Bin"
        pf.check(s)
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
    var b1 = new Bin
    var b2 = new Bin
    var h1 = new HBin
    var s1 = new SBin
    var p1 = new PBin
    var f1 = new FBin
    var pf1=new PFBin
    var pf2=new PFBin
    var h="Hard Bin"

    //Here bin is playing the role of HBin and HBin is created
    b1 play h1
    b1.check(h)
    +b1 create pf1
    b1 play p1
    +b1 getPF(h)


    println("------------------")
  }

  new BridgeCompartment{
    var b2 = new Bin
    var h1 = new HBin
    var s1 = new SBin
    var p1 = new PBin
    var f1 = new FBin
    var pf1=new PFBin
    var pf2=new PFBin


    //Here bin is playing the role of SBin and SBin is created
    var s="Soft Bin"
    b2 play s1
    b2.check(s)
    +b2 create pf2
    b2 play f1
    +b2 getPF(s)
    println("------------------")
  }

  new BridgeCompartment{
    var b2 = new Bin
    var h1 = new HBin
    var s1 = new SBin
    var p1 = new PBin
    var f1 = new FBin
    var pf1=new PFBin
    var pf2=new PFBin


    //Here bin is playing the role of SBin and SBin is created
    var s="Soft Bin"
    b2 play s1
    b2.check(s)
    +b2 create pf2
    b2 play p1
    +b2 getPF(s)
    println("------------------")
  }
}