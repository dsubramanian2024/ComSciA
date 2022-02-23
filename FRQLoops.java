import java.util.Scanner;

public class FRQLoops
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Choose a number: ");

    // capture response
    int n = keyboard.nextInt();
    //first
    for (int x = 1; x <= n; x++)
    {
      for (int y = 1; y <= x; y++)
      {
         System.out.print("*");
      }
      System.out.println(""); //prints out a new line
    }// ends first part

    //goes through n backwards
    for (int x = n; x >= 1; x--)
    {
      for (int y = x; y >= 1; y--)
      {
	       System.out.print("*");
      }
      System.out.println(""); //prints out a new line
    }
  }
}
