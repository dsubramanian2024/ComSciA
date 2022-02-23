import java.util.Scanner;

public class SumOfSqrsRec
{
  /**
  * Main Method
  * @param args The command line arguments
  */
  public static void main(String[] args)
  {
    System.out.println(addSquareLoop(5));
    System.out.println(addSquareRec(5));
  }
  public static int addSquareLoop(int n)
  {
    int sum = 0;
    for (int i = 1; i <= n; i++)
    {
      sum += i*i;
    }
    return sum;
  }
  public static int addSquareRec(int n)
  {
    if (n == 1)
      return 1;
    return n*n + addSquareRec(n - 1);
  }
}
