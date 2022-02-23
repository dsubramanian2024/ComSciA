import java.util.Random;

/**
* Problem Set 0
* Many functions which are called by RUnner0.java
* Divya Subramanian
* CSA - Block 6
* ProblemSet0.java
* @author Divya Subramanian
* @version 2.0
*/
public class ProblemSet0
{
  /** 1.
  * Method to convert decimal to toBinary
  * @param decimal which is integer that is converted to binary
  * @return String of binary number
  * An integer cannot be returned because the numbers would be added together instead of concatenated after
  */
  public static String toBinary(int decimal)
  {
    if (decimal == 0)
    {
      return "0";
    }
    if (decimal == 1)
    {
      return "1";
    }
    // found by finding remainder when divided by 2 and appending that to end and recall function for n / 2
    return toBinary(decimal / 2) + (decimal % 2);
  }
  /** 2.
  * Method to imitate rolling a die of n sides
  * @param n int which specifies random number is from 1 to n
  * @return int of random number from 1 to n
  */
  public static int rollDie(int n)
  {
    return (int) (Math.random() * n) + 1;
  }
  /** 3.
  * Method to print multiple table up to n
  * @param n int of how many lines in multiple table
  */
  public static void multiples(int n)
  {
    for (int x = 1; x <= n; x++)
    {
      for(int y = 1; y <= x; y++)
      {
        System.out.print(x * y);
        // prints tab
        System.out.print("\t");
      }
      //prints next line
      System.out.print("\n");
    }
  }
  /** 4.
  * Method to swap units and tens digit
  * @param n int whose last two digits are switched
  * @return int which is n with last two digits switched
  */
  public static int swap(int n)
  {
    int unitsDigit = n % 10;
    int tensDigit = ((n % 100) - unitsDigit)/10;
    int restOfNumber = (n / 100) * 100;

    //adds all parts together
    int swapNumber = restOfNumber + (unitsDigit * 10) + tensDigit;
    return swapNumber;
  }
  /** 5.
  * Method to print three ways to express XOR
  */
  public static void xor()
  {
    System.out.println("(x || y) && !(x && y)");
    System.out.println("!(x && y) || (x || y)");
    System.out.println("x^y");
  }
  /** 6a
  * Method to print n stars on one line
  * @param n int of how many stars to print
  */
  public static void printStars(int n)
  {
    //loops through n times to print n stars
    for (int x = 1; x <= n; x++)
    {
      System.out.print("*");
    }
  }
  /** 6b
  * Method to print triangle of stars iteratively
  * @param n number or rows in the triangle
  */
  public static void printTriangle(int n)
  {
    for (int x = 1; x <= n; x++)
    {
      printStars(x);
      System.out.print("\n");
    }
  }
  /** 6c
  * Method to print triangle of stars recursively
  * @param n number or rows in the triangle
  */
  public static void printRecursive(int n)
  {
    if (n == 0)
    {
      return;
    }
    printRecursive(n - 1);
    printStars(n);
    System.out.print("\n");
  }
  /** 6d
  * Method to print triangle of stars inverted
  * @param n number or rows in the triangle
  */
  public static void printRecursiveInverted(int n)
  {
    if (n <= 0)
    {
      return;
    }
    printStars(n);
    System.out.print("\n");
    printRecursiveInverted(n - 1);
  }
  /** 7a
  * Method to print sum of digits of input
  * @param n number whose digits are summed
  * @return int sum of digits
  */
  public static int sumDigits(int n)
  {
    if (n < 10)
    {
      return n;
    }
    int unitsDigit = n % 10;
    return unitsDigit + sumDigits(n / 10);
  }
  /** 7b
  * Method to check if input is divisible by 3 only using sum of Digits
  * @param n int that is checked
  * @return true if n is divisible by 3 or false if not divisible
  */
  public static boolean isDivisible(int n)
  {
    int sumOfDigits = sumDigits(n);
    while (sumOfDigits >= 10)
    {
      sumOfDigits = sumDigits(sumOfDigits);
    }
    // will keep calculating sum of digits unitl < 10 and then if sum is 3,6,9 will returntrue
    if(sumOfDigits == 9 || sumOfDigits == 6 || sumOfDigits == 3)
    {
      return true;
    }
    return false;
  }
  /** 8.
  * Method to print diamond of printStars
  * @param n int to have 2n - 1 rows
  */
  public static void printMoreStars(int n)
  {
    // prints the first half of the diamond
    for (int x = 1; x <= n; x++)
    {
      //prints the spaces before stars
      for(int space = 1; space <= n - x; space++)
      {
        System.out.print(" ");
      }
      //prints stars
      for (int star = 1; star <= (x * 2) - 1; star++)
      {
        System.out.print("*");
      }
      System.out.print("\n");
    }

    // prints the second half of the diamond
    for (int x = n - 1; x > 0; x--)
    {
      //prints the spaces before stars
      for (int space = 1; space <= n - x; space++)
      {
        System.out.print(" ");
      }
      //prints stars
      for (int star = 1; star <= (x * 2) - 1; star++)
      {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
  /** 9.
  * Method to print least number of contains
  * @param n int of number of cents
  * @return int[] of number of quarters, dimes, nickels, pennies
  */
  public static int[] leastCoins(int n)
  {
    int[] coinArr = new int[4];
    // quarters
    coinArr[0] = n / 25;
    n = n % 25;
    // dimes
    coinArr[1] = n / 10;
    n = n % 10;
    // nickels
    coinArr[2] = n / 5;
    n = n % 5;
    // pennies
    coinArr[3] = n;
    //returns the array
    return coinArr;
  }
  /** 10.
  * Method to print possible coin combinations
  * @param n int of cents
  * @return int number of coin combinations
  */
  public static int coins(int n)
  {
    int count = 0;
    for (int quarter = 0; quarter <= n / 25; quarter++)
    {
      for (int dime = 0; dime <= (n - quarter * 25) / 10; dime++)
      {
        for (int nickel = 0; nickel <= (n - (quarter * 25 + dime * 10)) / 5; nickel++)
        {
          int penny = n - (quarter * 25 + dime * 10 + nickel * 5);
          count++;
          System.out.println(quarter + " quarters, " + dime + " dimes, " + nickel + " nickels, "  + penny + " pennies.");
        }
      }
    }
    return count;
  }
}
