/**
* Runner 0
* Divya Subramanian
* CSA - Block 6
* Runner0.java
* @author Divya Subramanian
* @version 1.0
*/
public class Runner0
{
  /**
  * Main Method
  * @param args The command line arguments
  */
  public static void main(String[] args)
  {
    System.out.println(ProblemSet0.toBinary(12));
    System.out.println(ProblemSet0.toBinary(0));
    System.out.println(ProblemSet0.toBinary(1934));
    System.out.print("\n\n");

    System.out.println(ProblemSet0.rollDie(12));
    System.out.println(ProblemSet0.rollDie(1293));
    System.out.println(ProblemSet0.rollDie(2));
    System.out.print("\n\n");

    ProblemSet0.multiples(0);
    ProblemSet0.multiples(7);
    ProblemSet0.multiples(20);
    System.out.print("\n\n");

    System.out.println(ProblemSet0.swap(2));
    System.out.println(ProblemSet0.swap(19));
    System.out.println(ProblemSet0.swap(129405));
    System.out.print("\n\n");

    ProblemSet0.xor();
    System.out.print("\n\n");

    ProblemSet0.printStars(1);
    System.out.print("\n");
    ProblemSet0.printStars(20);
    System.out.print("\n");
    ProblemSet0.printStars(100);
    System.out.print("\n\n");

    ProblemSet0.printTriangle(1);
    ProblemSet0.printTriangle(4);
    ProblemSet0.printTriangle(30);
    System.out.print("\n\n");

    ProblemSet0.printRecursive(1);
    ProblemSet0.printRecursive(4);
    ProblemSet0.printRecursive(30);
    System.out.print("\n\n");

    ProblemSet0.printRecursiveInverted(1);
    ProblemSet0.printRecursiveInverted(4);
    ProblemSet0.printRecursiveInverted(30);
    System.out.print("\n\n");

    System.out.println(ProblemSet0.sumDigits(0));
    System.out.println(ProblemSet0.sumDigits(19));
    System.out.println(ProblemSet0.sumDigits(129405));
    System.out.print("\n\n");

    System.out.println(ProblemSet0.isDivisible(0));
    System.out.println(ProblemSet0.isDivisible(1977));
    System.out.println(ProblemSet0.isDivisible(254));
    System.out.print("\n\n");

    ProblemSet0.printMoreStars(1);
    ProblemSet0.printMoreStars(4);
    ProblemSet0.printMoreStars(30);
    System.out.print("\n\n");

    System.out.println(ProblemSet0.leastCoins(0));
    System.out.println(ProblemSet0.leastCoins(1977));
    System.out.println(ProblemSet0.leastCoins(267));
    System.out.print("\n\n");

    System.out.println(ProblemSet0.coins(0));
    System.out.println(ProblemSet0.coins(26));
    System.out.println(ProblemSet0.coins(1000));
    System.out.print("\n\n");
  }
}
