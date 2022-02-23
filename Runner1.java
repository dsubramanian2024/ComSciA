import java.util.ArrayList;
/**
 * This is the main program you will use to test your ProblemSet 1
 * Create different testing scenarions here to validate your programs work as expected
 * There are least 3 test cases for each problem.
 * ProblemSet1 will receive input from this file.
 *
 * @author Divya Subramanian
 * @version 2.0
 */
public class Runner1
{
  /**
   * Main method
   * @param args The command line arguments
   */
  public static void main(String[] args)
  {

      //Problem 1 - fibArray
      System.out.println("Problem 1 - fibArray");

      System.out.print("fibArray(2) = ");
      printArray(ProblemSet1.fibArray(2));

      System.out.print("fibArray(10) = ");
      printArray(ProblemSet1.fibArray(10));

      System.out.print("fibArray(100) = ");
      printArray(ProblemSet1.fibArray(25));
      System.out.println("\n");


      int[] arr1 = {};
      int[] arr2 = {1};
      int[] arr3 = {-1, 7, 203, 6, 5, 9, 11, 33, 91};


      //Problem 2a - rotateLeft
      // for each test case i print orignal array and then print the array after function is completed
      System.out.println("Problem 2a - rotateLeft");
      System.out.print("Arr1 = ");
      printArray(arr1);
      System.out.print("rotateLeft(arr1) = ");
      ProblemSet1.rotateLeft(arr1);
      printArray(arr1);

      System.out.print("Arr2 = ");
      printArray(arr2);
      System.out.print("rotateLeft(arr2) = ");
      ProblemSet1.rotateLeft(arr2);
      printArray(arr2);

      System.out.print("Arr3 = ");
      printArray(arr3);
      System.out.print("rotateLeft(arr3) = ");
      ProblemSet1.rotateLeft(arr3);
      printArray(arr3);
      System.out.println("\n");
      // end of problem 2a


      //Problem 2b - rotateRight
      // for each test case i print orignal array and then print the array after function is completed
      System.out.println("Problem 2b - rotateRight");
      System.out.print("Arr1 = ");
      printArray(arr1);
      System.out.print("rotateRight(arr1) = ");
      ProblemSet1.rotateRight(arr1);
      printArray(arr1);

      System.out.print("Arr2 = ");
      printArray(arr2);
      System.out.print("rotateRight(arr2) = ");
      ProblemSet1.rotateRight(arr2);
      printArray(arr2);

      System.out.print("Arr3 = ");
      printArray(arr3);
      System.out.print("rotateRight(arr3) = ");
      ProblemSet1.rotateRight(arr3);
      printArray(arr3);
      System.out.println("\n");
      //end of problem 2b


      //Problem 2c - rotate
      // for each test case i print orignal array and then print the array after function is completed
      System.out.println("Problem 2c - rotate");
      System.out.print("Arr1 = ");
      printArray(arr1);
      System.out.print("rotate(arr1, 2) = ");
      ProblemSet1.rotate(arr1, 2);
      printArray(arr1);

      System.out.print("Arr3 = ");
      printArray(arr3);
      System.out.print("rotate(arr3, 3) = ");
      ProblemSet1.rotate(arr3, 3);
      printArray(arr3);

      System.out.print("Arr3 = ");
      printArray(arr3);
      System.out.print("rotate(arr3, -2) = ");
      ProblemSet1.rotate(arr3, -2);
      printArray(arr3);
      System.out.println("\n");
      //end of problem 2c


      //Problem 3 - multiply
      System.out.println("Problem 3 - multiply");

      //arrays to be multiplied
      int[][] A = {{1, 2, 3}, {4, 5, 6}};
      int[][] B = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      int[][] C = {{0, 1}, {4, 5}};
      int[][] D = {{1, 2, 3}, {4, 5, 6}, {1, 2, 3}, {4, 5, 6}};

      //prints all of the arrays
      System.out.println("A = ");
      print2d(A);
      System.out.println("B = ");
      print2d(B);
      System.out.println("C = ");
      print2d(C);
      System.out.println("D = ");
      print2d(D);

      System.out.println("multiply(A, B) = ");
      print2d(ProblemSet1.multiply(A, B));

      System.out.println("multiply(C, A) = ");
      print2d(ProblemSet1.multiply(C, A));

      System.out.println("multiply(D, B) = ");
      print2d(ProblemSet1.multiply(D, B));
      System.out.println("\n");
      //end of problem 3


      //Problem 4 - PascalTriangle
      System.out.println("Problem 4 - Pascal Triangle");
      System.out.println("PascalTriangle(1) = ");
      print2d(ProblemSet1.PascalTriangle(1));

      System.out.println("PascalTriangle(5) = ");
      print2d(ProblemSet1.PascalTriangle(5));

      System.out.println("PascalTriangle(15) = ");
      print2d(ProblemSet1.PascalTriangle(15));
      System.out.println("\n");


      //Array lists to be used in next three problems
      ArrayList<String> list1 = new ArrayList<String>();
      list1.add("hello");
      list1.add("hi");
      list1.add("hello");
      list1.add("bye");
      list1.add("goodbye");
      list1.add("hello");
      list1.add("hi");
      ArrayList<String> list2 = new ArrayList<String> ();
      list2.add("apple");
      list2.add("2uchini");
      list2.add("banana1");
      list2.add("banana");
      list2.add("apple");
      list2.add("banana");
      list2.add("orange19");
      ArrayList<String> list3 = new ArrayList<String>();
      list3.add("R2-D2");
      list3.add("Darth Vader");
      list3.add("C - 3PO");
      list3.add("Yoda");


      //Problem 5 - reverseList
      System.out.println("Problem 5 - reverseList");
      System.out.println("List1 = " + list1);
      ProblemSet1.reverseList(list1);
      System.out.println("reverseList(list1) = " + list1);

      System.out.println("List2 = " + list2);
      ProblemSet1.reverseList(list2);
      System.out.println("reverseList(list2) = " + list2);

      System.out.println("List3 = " + list3);
      ProblemSet1.reverseList(list3);
      System.out.println("reverseList(list3) = " + list3);
      System.out.println("\n");


      //Problem 6 - removeDuplicates
      System.out.println("Problem 6 - removeDuplicates");
      System.out.println("List1 = " + list1);
      ProblemSet1.removeDuplicates(list1);
      System.out.println("removeDuplicates(list1) = " + list1);

      System.out.println("List2 = " + list2);
      ProblemSet1.removeDuplicates(list2);
      System.out.println("removeDuplicates(list2) = " + list2);

      System.out.println("List3 = " + list3);
      ProblemSet1.removeDuplicates(list3);
      System.out.println("removeDuplicates(list3) = " + list3);
      System.out.println("\n");


      //Problem 7 - replaceDigits
      System.out.println("Problem 7 - replaceDigits");
      System.out.println("List1 = " + list1);
      ProblemSet1.replaceDigits(list1);
      System.out.println("replaceDigits(list1) = " + list1);

      System.out.println("List2 = " + list2);
      ProblemSet1.replaceDigits(list2);
      System.out.println("replaceDigits(list2) = " + list2);

      System.out.println("List3 = " + list3);
      ProblemSet1.replaceDigits(list3);
      System.out.println("replaceDigits(list3) = " + list3);
      System.out.println("\n");


      ArrayList<Double> intlist = new ArrayList<Double>();
      intlist.add(1.0);
      intlist.add(5.2);
      intlist.add(7.5);
      intlist.add(15.0);
      intlist.add(15.0);
      intlist.add(30.4);


      //Problem 8 - insertSort
      System.out.println("Problem 8 - insertSort");
      System.out.println("List = " + intlist);
      ProblemSet1.insertSort(intlist, 0.0);
      System.out.println("insertSort(intlist, 0.0) = " + intlist);

      System.out.println("List = " + intlist);
      ProblemSet1.insertSort(intlist, 15.0);
      System.out.println("insertSort(intlist, 15.0) = " + intlist);

      System.out.println("List = " + intlist);
      ProblemSet1.insertSort(intlist, 39.1);
      System.out.println("insertSort(intlist, 39.1) = " + intlist);
      System.out.println("\n");


      //Problem 9 - top5
      System.out.println("Problem 9 - top5");
      int[] top5arr1 = {1, 6, 3, 10, 7, 2, 4, 2, 8};
      int[] top5arr2 = {1, 2, 3, 4, 5};
      int[] top5arr3 = {6, 6, 7, 7, 8, 8, 9};

      System.out.print("top5arr1 = ");
      printArray(top5arr1);
      System.out.println("top5(top5arr1) = " + ProblemSet1.top5(top5arr1));

      System.out.print("top5arr2 = ");
      printArray(top5arr2);
      System.out.println("top5(top5arr2) = " + ProblemSet1.top5(top5arr2));

      System.out.print("top5arr3 = ");
      printArray(top5arr3);
      System.out.println("top5(top5arr3) = " + ProblemSet1.top5(top5arr3));
      System.out.println("\n");
      // end of problem 9


      //problem 10
      System.out.println("Problem 10 - seating");
      ArrayList<String> seatinglist = new ArrayList<String>();
      seatinglist.add("1,3");
      seatinglist.add("0,4");
      seatinglist.add("2,10");
      seatinglist.add("2,20");
      seatinglist.add("5,3");

      System.out.println("Seating list = " + seatinglist);
      int[][] seatingArr1 = ProblemSet1.populateSeating(1, seatinglist);
      int[][] seatingArr2 = ProblemSet1.populateSeating(3, seatinglist);
      int[][] seatingArr3 = ProblemSet1.populateSeating(4, seatinglist);

      //part a
      System.out.print("populateSeating(1, seatinglist) = ");
      print2d(seatingArr1);

      System.out.print("populateSeating(3, seatinglist) = ");
      print2d(seatingArr2);

      System.out.print("populateSeating(4, seatinglist) = ");
      print2d(seatingArr3);

      //part b
      System.out.println("printSeating(seatingArr1)");
      ProblemSet1.printSeating(seatingArr1);

      System.out.println("printSeating(seatingArr2)");
      ProblemSet1.printSeating(seatingArr2);

      System.out.println("printSeating(seatingArr3)");
      ProblemSet1.printSeating(seatingArr3);

      //part c
      System.out.println("bookSeats(seatingArr2, 11)");
      System.out.println(ProblemSet1.bookSeats(seatingArr2, 11));

      System.out.println("bookSeats(seatingArr2, 3)");
      System.out.println(ProblemSet1.bookSeats(seatingArr2, 3));

      System.out.println("bookSeats(seatingArr2, 28)");
      System.out.println(ProblemSet1.bookSeats(seatingArr2, 28));
  }

  /**
  * Takes in an array and prints import junit.framework.TestCase;
  */
  public static void printArray(int[] a)
  {
    System.out.print("{");
    for(int i = 0; i < a.length - 1; i++)
    {
      System.out.print(a[i] + ", ");
    }
    if (a.length > 0)
    {
      System.out.print(a[a.length-1]);
    }
    System.out.println("}");
  }

  /**
  * Prints the 2d array
  */
  public static void print2d(int[][] a)
  {
    System.out.print("{");
    for(int i = 0; i < a.length; i++)
    {
      printArray(a[i]);
    }
    System.out.println("}");
  }
}
