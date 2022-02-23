/**
* This class demonstrates how to create and print a 2D array
* Don't forget to change the file name to match the class name
* @author David Gonzalez
* @version 1.0
*/
public class Create2DArray
{
  /**
  * Main method
  * @param args Command line arguments
  */
  public static void main(String[] args)
  {
    System.out.println("JAGGED ARRAY");
    int[][] myNumbers = {{1, 2, 3, 4}, {5, 6, 7}};
    printArray(myNumbers);
    System.out.println();

    // create student array
    System.out.println("STUDENT ARRAY");
    String[][] myStudentArray = createStudentArray();
    printArrayStudent(myStudentArray);
  }
  public static String[][] createStudentArray()
  {
    //populte w data
    String[][] arr = new String[3][3];
    arr[0][0] = "Amy";
    arr[0][1] = "Pond";
    arr[0][2] = "111-111-1111";

    arr[1][0] = "Rose";
    arr[1][1] = "Tyler";
    arr[1][2] = "222-222-2222";

    arr[2][0] = "Donna";
    arr[2][1] = "Noble";
    arr[2][2] = "333-333-3333";

    return arr;
  }
  /**
  * Create a square 2D array of any size where numbers are incremented
  * from the upper left corner to the bottom right corner
  * @param size The size of the square array
  * @return The created array
  */
  public static int[][] create2D(int size)
  {
    return null;
  }
  /**
  * Print a 2D array of integers
  * @param array The int[][] to be printed
  */
  public static void printArray(int[][] array)
  {
    for (int r = 0; r < array.length; r++)
    {
      for (int c = 0; c < array[r].length; c++)
      {
        System.out.print(array[r][c] + " ");
      }
      System.out.println();
    }
  }
  /**
  * Print a 2D array of integers using tabs to separate elements
  * @param array The int[][] to be printed
  */
  public static void printArrayTabs(int[][] array)
  {
    for (int r = 0; r < array.length; r++)
    {
      for (int c = 0; c < array[r].length; c++)
      {
        System.out.print(array[r][c] + "\t");
      }
      System.out.println();
    }
  }
  public static void printArrayStudent(String[][] array)
  {
    for (int r = 0; r < array.length; r++)
    {
      for (int c = 0; c < array[r].length; c++)
      {
        System.out.print(array[r][c] + "\t");
      }
      System.out.println();
    }
  }
}
