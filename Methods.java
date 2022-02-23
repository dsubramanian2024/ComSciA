public static Methods
{
  public static void main(String[] args)
  {

    String firstName = "David";
    int i = 10;
    double x = 6.2;

    myFunction(firstName, i, x);

    int result = myOtherFunction();

    generateRandomNumber(3);
  }

  public static void myFunction(String s, int a, double y)
  {
    System.out.printls("Inside of myFunction");
    System.out.printls(a + y)
  }

  public static int myOtherFunction()
  {
    int z = 1

    return z;
  }

  public static void generateRandomNumber(int numOfLoops)
  {
    for (int x = 1;x <= numOfLoops; x++)
    {
      System.out.println((int)(Math.random() * 10) + 1);
    }
  }
}
