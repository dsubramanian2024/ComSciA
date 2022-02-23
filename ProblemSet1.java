import java.util.ArrayList;
/**
 * Class that will store the functions for each problem in ProblemSet1
 * All functions will be called from another program.  You should not expect user input from the Scanner object.
 * Be sure all of your method names match the instructions document.  Do not vary from the method names in the document.
 * Testing took especially long for me but overall this was easier
 *
 * @author Divya Subramanian
 * @version 2.0
 */
public class ProblemSet1
{

  /** 1.
   * Method to write n fibonacci numbers to an array
   * @param n Number of Fibonacci numbers in the array
   * @return int[] of the n Fibonacci numbers
   */
  public static int[] fibArray(int n)
  {
    //declare new array
    int[] fibIntArr = new int[n];

    //first two values of arr are always 1 - it is assumed that length of input array >= 2
    fibIntArr[0] = 1;
    fibIntArr[1] = 1;

    //loops through remainder of array - elements 0 and 1 were skipped bc they were already initialized as 1
    for (int i = 2; i < n; i++)
    {
      //element i is the sum of the previous two elements
      fibIntArr[i] = fibIntArr[i - 1] + fibIntArr[i - 2];
    }
    return fibIntArr;
  }


  /** 2.a
  * Method to rotate an array one position to the left
  * @param array to be rotated
  */
  public static void rotateLeft(int[] array)
  {
    //function will only continue if array has length greater than 0
     if (array.length > 0)
     {
       //the first element is stored separately so the last element can be set to it later
       int firstElement = array[0];

       //loops through array (excluding last element) and sets current element to take value of next element
       //this is what shifts every element over left
       for (int i = 0; i < array.length - 1; i++)
       {
         array[i] = array[i + 1];
       }

       //the last element is set to the original first element
       array[array.length - 1] = firstElement;
     }
  }

  /** 2.b
  * Method to rotate an array one position to the right
  * @param array to be rotated
  */
  public static void rotateRight(int[] array)
  {
    //function will only continue if array has length greater than 0
    if (array.length > 0)
    {
      //the last element is stored separately so the first element can be set to it later
      int lastElement = array[array.length - 1];

      //loops through array backwards(excluding first element) and sets current element to take value of previous element
      //this is what shifts every element over right
      for (int i = array.length - 1; i > 0; i--)
      {
        array[i] = array[i - 1];
      }

      //the first element is set to what used to be the last element
      array[0] = lastElement;
    }
  }

  /** 2.c
  * Method to rotate an array d positions wither to left or right determined by the sign of d
  * @param array to be rotated
  * @param d if d is positive, array fotated to the right d times otherwise rotated to the left d times
  */
  public static void rotate(int[] array, int d)
  {
     if (d < 0)
     {
       //if d < 0 then array is rotated left -d times
       for (int i = 0; i < d * -1; i++)
       {
         rotateLeft(array);
       }
     }
     else
     {
       //if d is positive array is rotated right d times
       for (int i = 0; i < d; i++)
       {
         rotateRight(array);
       }
     }
  }


  /** 3.
  * Method to multiple two 2d arrays
  * @param int[][] a the first 2d array
  * @param int[][] b the second 2d array
  * @return int[][] array with product of both matrices
  */
  public static int[][] multiply(int[][] a, int[][] b)
  {
    //new array created with number of rows of a and cols of b
     int[][] productArr = new int[a.length][b[0].length];

     //loops through every element in productArr
     for (int row = 0; row < productArr.length; row++)
     {
       for (int col = 0; col < productArr[0].length; col++)
       {
         int sum = 0;

         //calculates sum by adding up the products of the column of a with the row of b
         for (int i = 0; i < b.length; i++)
         {
           sum += a[row][i] * b[i][col];
         }
         // the element is set to the sum
         productArr[row][col] = sum;
       }
     }
     return productArr;
  }1 2 3 4


  /** 4.
  * Method to return Pascal's Triangle with n rows
  * the first and last element in every row is 1 and in between, each element is the sum of the two above elements
  * @param n num of rows
  * @return int[][] array storing the triangle
  */
  public static int[][] PascalTriangle(int n)
  {
    //new array created with n rows
     int[][] triangle = new int[n][];

     //loops through each row
     for (int row = 0; row < n; row++)
     {
       // every row is initialized with row # or elements
       triangle[row] = new int[row + 1];

       //the first element of the row is 1
       triangle[row][0] = 1;

       // loops through every element in the row
       for (int col = 1; col < triangle[row].length - 1; col++)
       {
         //that element is set to sum of the two elements above
         triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col];
       }
       //the last element in the row is 1
       triangle[row][row] = 1;
     }
     return triangle;
  }


  /** 5.
  * Takes in an array list and reverses by looping through first half of elements and switching the first - last, second - second to last...
  * @param list array list which is to be reversed
  */
  public static void reverseList(ArrayList<String> list)
  {
    int listSize = list.size() - 1;

    //goes through the first half of elements
    for (int i = 0; i < (listSize + 1) / 2; i++)
    {
      //switch the fist - last , second - second to last... element by using temp and switiching vals
      String temp = list.get(i);
      list.set(i, list.get(listSize - i));
      list.set(listSize - i, temp);
    }
  }


  /** 6.
  * Method to remove duplicates of an element by comparing the indexes
  * @param list which repeated elements are removed
  */
  public static void removeDuplicates(ArrayList<String> list)
  {
    //loops through elements
    for (int i = 0; i < list.size(); i++)
    {
      //compares indexof element with current index to see if there was a previous instance
      if(indexOfList(list, list.get(i)) != i)
      {
        list.remove(i);
        i--;
      }
    }
  }

  /**
  * Method to get index of an element in an arraylist
  * @param list array list which is searched
  * @param str string that is searched for
  * @return int index
  */
  public static int indexOfList(ArrayList<String> list, String str)
  {
    //loops through arraylist
    for (int i = 0; i < list.size(); i++)
    {
      //if the element and inputted string are the same, that index is returned
      if (list.get(i).equals(str))
      {
        return i;
      }
    }
    //if str is not present in list, -1 is returned
    return -1;
  }


  /** 7.
  * Method to take in a arraylist of strings and replace all numbers with z
  * @param list which is used
  */
  public static void replaceDigits(ArrayList<String> list)
  {
    for (int elementCount = 0; elementCount < list.size(); elementCount++)
    {
      //string stores the current element
      String elementStr = list.get(elementCount);

      //loops through every character in string
      for (int charCount = 0; charCount < elementStr.length(); charCount++)
      {
        //gets each character by using substring
        String charInStr = elementStr.substring(charCount, charCount + 1);

        //compares character to 0 to see if it is a number
        if (charInStr.compareTo("0") <= 9 && charInStr.compareTo("0") >= 0)
        {
          //if so, the number is replaces with a z
          // new string is substring from 0 up till charIn Str + z + rest of string
          elementStr = elementStr.substring(0, charCount) + "z" + elementStr.substring(charCount + 1, elementStr.length());
        }
        //set the list element to be the new string
        list.set(elementCount, elementStr);
      }
    }
  }


  /** 8.
  * Method take a sorted arraylist of doubles and input d into the correct position
  * @param list in which d is added
  * @param d double which is added to list
  */
  public static void insertSort(ArrayList<Double> list, double d)
  {
    //loops through every element in the list
    for (int i = 0; i < list.size(); i++)
    {
      // if the value of the current element is greater than d, d is added before this element in the list
      // this works under the assumption that the list is ordered
      // checks also if the previous element is smaller or the element is #0 so that not repeatedly inputting d into the list
      if (list.get(i) > d && (i == 0 || list.get(i - 1) <= d))
      {
        // adding d right before element i
        list.add(i, d);
        i++;
      }
    }
    //check if d is greater than the last element of the list
    if (d > list.get(list.size() - 1))
    {
      list.add(d);
    }
  }


  /** 9.
  * Method that takes array of integers and return ArrayList that contains top 5 largest values in the aray
  * @param arr array whose top five numbers are returned
  * @return ArrayList<Integer> which contains top 5 ints in array in decreasing order
  */
  public static ArrayList<Integer> top5(int[] arr)
  {
    //array list which stores the top 5 numbers from the array in decreasing order
    ArrayList<Integer> top5 = new ArrayList<Integer>();

    //algorithm of selection sort but done only 5 times
    for (int x = 0; x < 5; x++)
    {
      //stores the index of the element that is biggest
      int indexMax = x;

      //loops through array starting from index x + 1
      for(int y = x + 1; y < arr.length; y++)
      {
        //indexMax is set to y if element y is greater then the element at indexMax
        if (arr[y] > arr[indexMax])
        {
          indexMax = y;
        }
      }

      //uses a temp variable to switch the values at x and indexMax
      int temp = arr[indexMax];
      arr[indexMax] = arr[x];
      arr[x] = temp;
      //add the number to the array list
      top5.add(temp);
    }
    return top5;
  }


  /** 10a
  * Method that takes a number of rows and an arraylist of seats. A 2d array is created and the seats in takenSeat are set to 0
  * @param n number of rows
  * @param takenSeat arraylist of strings which holds all the seats which are taken
  * @return int[][] which represents the seating chart in which 1 means the seat is taken
  */
  public static int[][] populateSeating(int n, ArrayList<String> takenSeat)
  {
    //create seat array with n rows
    int[][] seatArr = new int[n][];
    //keeps track of number of cols in each row
    int colNum = 10;
    //for every row, a new array is initialized with colnum number of columns
    for (int i = 0; i < n; i++)
    {
      seatArr[i] = new int[colNum];
      //every row has two more columns than previous row
      colNum += 2;
    }

    //go through inputted takenlist
    for (int listCount = 0; listCount < takenSeat.size(); listCount++)
    {
      //stores tthe value of the current element in the list
      String seatStr = takenSeat.get(listCount);

      //gets the index of the comma withing the string
      int commaIndex = seatStr.indexOf(",");

      //the x and y vals are found by using the commaIndex to make two separate substrings
      //int are then taken from those substrings by using parseInt
      //the first val is the row num and the number after the comma is the column num
      int xVal = Integer.parseInt(seatStr.substring(0, commaIndex), 10);
      int yVal = Integer.parseInt(seatStr.substring(commaIndex + 1, seatStr.length()), 10);

      //if the x and y vals are within the specified bounds, the value of that element becomes 1
      if (xVal < n && yVal < seatArr[xVal].length)
      {
        seatArr[xVal][yVal] = 1;
      }
    }

    return seatArr;
  }

  /** 10b
  * Method to print seating when given the 2d arr
  * @param seating arr which is used to print seating chart
  */
  public static void printSeating(int[][] seating)
  {
    int numOfRows = seating.length;

    //loops through rows in seating
    for (int row = 0; row < numOfRows; row++)
    {
      //prints corresponding spaces which is determined by which row is being printed and the total number of rows in the 2d array
      printSpaces(row, numOfRows);

      // prints the row with plus and dashes
      printPlusDashRow(seating, row);

      //once again prints spaces
      printSpaces(row, numOfRows);

      //prints the values of the seating chart
      for (int col = 0; col < seating[row].length; col++)
      {
        System.out.print("| " + seating[row][col] + " ");
      }
      System.out.println("|");
    }
    //an extra dash row at the very bottom of the chart
    printPlusDashRow(seating, numOfRows - 1);
  }

  /**
  * Method to print certain number of spaces to align the rows of the printSeating function
  * @param rowNum current index of row being printed
  * @param numOfRows total number of rows in 2d array
  */
  public static void printSpaces(int rowNum, int numOfRows)
  {
    //adds an extra space to all the rows except last ones to make up for one space difference
    if (rowNum < numOfRows - 1)
    {
      System.out.print(" ");
    }

    //find the difference in the current row and number of rows and prints a sequence of three spaces that many times
    for (int i = 0; i < numOfRows - (rowNum + 1); i++)
    {
      System.out.print("   ");
    }
  }

  /**
  * Method to print the row which contains the plus and dashes
  * @param seating arr which is used to print seating chart
  * @param row current row num
  */
  public static void printPlusDashRow(int[][] seating, int row)
  {
    //for every column in the row, one plus and three dashes are printed
    for (int col = 0; col < seating[row].length; col++)
    {
      System.out.print("+---");
    }
    //extra + to be added at end
    System.out.println("+");
  }

  /** 10.c
  * Method that checks if n seat can be booked within a given seating chart
  * @param seating the seating chart
  * @return true if there are n seats in a row or false otherwise
  */
  public static boolean bookSeats(int[][] seating, int n)
  {
    for (int row = 0; row < seating.length; row++)
    {
      int consecutiveSeats = 0;
      for (int col = 0; col < seating[row].length; col++)
      {
        if (seating[row][col] == 0)
        {
          consecutiveSeats++;
        }
        else
        {
          consecutiveSeats = 0;
        }
        if (consecutiveSeats >= n)
        {
          return true;
        }
      }
    }
    return false;
  }

}
