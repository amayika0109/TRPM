package scroll.examples
import scroll.internal.support.DispatchQuery.Bypassing
import scroll.internal.Compartment
import scroll.internal.support.DispatchQuery
import java.util.ArrayList
import java.util.HashMap

object CompositeExample extends App {

  class CompositeCompartment() extends Compartment {

    private val parents: HashMap[Wafer, Parent] = new HashMap
    private val dchildren: HashMap[Wafer, Child] = new HashMap
    private val fchildren: HashMap[Die, Child] = new HashMap
    var root: Parent = null


    def addRootParent(p: Parent): Unit = {
      if (p != null)
        root = p
    }

    /*Parent class
    Add(): Create the list of child objects and add them
    Sum(): provide the size of the parent object
    */
    class Parent {
      private val children = new ArrayList[Object]

      def add(c: Object): Boolean = {
        val result = children.add(c)
        if (result) +c setParent (this)
        result
      }

      def sum(): Int = {
        println("-----Children Size: " + children.size())
        var size: Int = +this getSize()
        children.forEach(c => {
          val i: Int = +c sum()
          size += i
        })
        size
      }

      def list(): String = {
        val ls = new ArrayList[String]
        ls.add(+this getName)

        children.forEach(c => {
          val s: String = +c list()
          ls.add(s)
        })
        String.join("\n", ls)
      }
    }

    /* Child Class
    Set and Get the Parent of this child object
     */
    class Child {
      private var parent: Parent = null

      def setParent(p: Parent): Unit = {
        parent = p
      }

      def getParent(): Parent = parent

      def sum(): Int = +this getSize()

      def list(): String = +this getName()
    }
    class Wafer {
      var name = ""
      var size = 0

      def this(n: String) {
        this()
        name = n
      }

      override def toString: String = "d " + name + " (" + size + " Byte)"
      def getName(): String = name
      def getSize(): Int = size
      def setSize(s: Int): Unit = {
        size = s
      }
    }

    class Die {
      var name = ""
      var size = 0

      def this(n: String) {
        this()
        name = n
      }

      def this(n: String, s: Int) {
        this()
        name = n
        size = s
      }

      override def toString: String = "- " + name + " (" + size + " Byte)"
      def getName(): String = name
      def getSize(): Int = size

      def append(c: Int): Unit = {
        size += 1
      }
    }


  }

  new CompositeCompartment {
    val wafer1 = new Wafer("dir1")
    wafer1.setSize(1000)
    val wafer2 = new Wafer("dir2")
    wafer2.setSize(200)
    val wafer3 = new Wafer("dir3")
    wafer3.setSize(500)

    val die1 = new Die("file1", 70)
    val die2 = new Die("file2", 10)
    val die3 = new Die("file3", 50)
    val die4 = new Die("file4", 250)

    val parent1 = new Parent
    val parent2 = new Parent
    val parent3 = new Parent
    val dieChild1 = new Child
    val dieChild2 = new Child
    val dieChild3 = new Child

    wafer1 play parent1
    wafer2 play parent2
    wafer3 play parent3

    +wafer1 add wafer2
    +wafer1 add wafer3

    die1 play dieChild1
    die2 play dieChild2
    die3 play dieChild3

    //For testing roles working or not
    //
    println(+wafer2 add dieChild1)
    println(+wafer3 add dieChild2)
    println("Wafer1 is playing Parent:" + (+wafer1).isPlaying[Parent])
    println("Wafer2 is playing child:" + (+wafer2).isPlaying[Child])
    println("Wafer3 is playing child:" + (+wafer3).isPlaying[Child])
    println("Wafer2 is playing Parent:" + (+wafer2).isPlaying[Parent])
    println("Wafer3 is playing Parent:" + (+wafer3).isPlaying[Parent])
    println("size of Wafer1: " + wafer1.getSize)
    println("size of Die1: " + die1.getSize)
    //println(+dir1 add parent2)
    //println(+dir1 add parent3)
    //

    //Current size of the directory
    //println("Check Total size")

    var totalSize: Int = +wafer1 sum
      println("Total size of lot: " + totalSize)

    /*
    val fileChild4 = new Child
    file4 play fileChild4
    +dir2 add file4
    println("")
    println("New file has added----------")
    var totalNewSize: Int = +dir1 sum()
    println("Total size of root directory with new file: " + totalNewSize)
    */

  }
}

