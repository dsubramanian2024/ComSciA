/**
* Farmers game
* Divya Subramanian
* CSA - Block 6
* FarmersGame.java
* @author Divya Subramanian
* @version 1.0
*/

import java.util.Scanner;

public class FarmersGame
{
  /**
  * Main Method
  * @param args The command line arguments
  */
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);
    // introduction to game
    System.out.println("Welcome to the Farmer's Game! The Farmer’s Game is an old riddle where a farmer has to cross a river with a wolf, a sheep, and a cabbage. He has a boat that can only fit himself and one other thing, either the cabbage, the sheep, or the wolf. The problem is that he cannot leave the wolf and sheep alone on the river bank because the wolf would eat the sheep. Also, he cannot leave the sheep and the cabbage alone on the river bank because the sheep would eat the cabbage.To win the game, you must determine how to take all the items one at a time from one bank to the other. If the wolf and the sheep are left alone on one bank, or the sheep and the cabbage are left alone on one bank, you lose the game. Good Luck!");

    // boolean array in order of farmer, wolf, sheep, and then cabbage- automatically set values to false
    boolean[] arr = new boolean[4];

    //loops through game as long as user hasn't lost or won
    while (loseGame(arr) == false && winGame(arr) == false)
    {
      printRiver(arr);
      int inputArrNum = getInput(arr);
      switchVal(arr, inputArrNum);
      if (inputArrNum != 0)
        //switches value of farmer bc farmer crosses river everytime
        switchVal(arr, 0);
    }
  }
  /**
  * Method to print game status
  * @param arr The array which is used to print charachters on each side
  */
  public static void printRiver(boolean[] arr)
  //prints the game status
  {
    printSide(arr, false);
    System.out.println("------------------------------");
    System.out.println("~~~        ~~~~     ~~~     ~~");
    System.out.println("  ~~~~~        ~~~      ~~~~~ ");
    System.out.println("------------------------------");
    printSide(arr, true);
  }
  /**
  * Method to print all the characters on a certain side of the river
  * @param arr The boolean array which is used to print charachters on each side
  * @param x The boolean used to check which side of the river to print
  */
  public static void printSide(boolean[] arr, boolean x)
  {
    String[] namearr = new String[] {"Farmer", "Wolf", "Sheep", "Cabbage"};
    // loops through elements in the array and prints them only if they are on the same side as x
    for (int i = 0; i <= 3; i++)
      if (arr[i] == x)
        System.out.print(namearr[i] + "  ");
    System.out.println();
  }
  /**
  * Method that checks to see if all characters have crossed river successfully and user wins
  * @param arr The boolean array which says location of each character. It used to see if all indexes are true, meaning they crossed the river
  * @return true if all characters have corssed river and user wins game or false otherwise
  */
  public static boolean winGame(boolean[] arr)
  {
    // loops through array and checking if there are any characters who have not crossed river
    for (int i = 0; i <= 3; i++)
      if (arr[i] == false)
        return false;
    // if all characters have crossed river, returns true and user wins
    System.out.println("Congrats! You successfully allowed all the characters to cross the river!!");
    return true;
  }
  /**
  * Method that checks if the river has two characters on the same side which would make them lose the game
  * @param arr Boolean array which contains location of each characters
  * @return true if wolf eats sheep or sheep eats cabbage or false if none of the characters are eaten
  */
  public static boolean loseGame(boolean[] arr)
  {
    // Wolf and Sheep without Farmer
    if (((arr[1] == true) && (arr[2] == true) && (arr[0] == false)) || ((arr[1] == false) && (arr[2] == false) && (arr[0] == true)))
    {
      printRiver(arr);
      System.out.println("Oops, you lost! The wolf ate the sheep :(");
      return true;
    }
    // Sheep and Cabbage together without Farmer
    if ((arr[3] == true) && (arr[2] == true) && (arr[0] == false)  || ((arr[3] == false) && (arr[2] == false) && (arr[0] == true)))
    {
      printRiver(arr);
      System.out.println("Oops, you lost! The sheep ate the cabbage :(");
      return true;
    }
    return false;
  }
  /**
  * Method that gets ser inputs and error handles
  * @param arr Boolean array which contains location of each character
  * @return inpnum Array index (int) of the users input
  */
  public static int getInput(boolean[] arr)
  {
    Scanner kboard = new Scanner(System.in);
    System.out.println("Assuming the farmer will cross the river every turn, what other character would you like for the farmer to take with him? ");
    String inp;
    int inpnum;
    // gets user to input a character to move across the river with the farmer
    do{
      System.out.print("Please enter only 'W' for wolf, 'S' for sheep, 'C' for cabbage, or 'N' for nothing:   ");
      inp = kboard.nextLine();
      inpnum = strIndex(inp);
      // check if inp is on same side of river as farmer (if not asks the user to re-enter) and is the input is valid
      if(inpnum != -1 && arr[inpnum] != arr[0])
      {
        System.out.print("That is not on the same side of the river as the farmer. Make sure both characters are on the same side. ");
      }
    } while(inpnum == -1 || arr[inpnum] != arr[0]);
    //returns the array index of the input
    return inpnum;
  }
  /**
  * Method that returns the array index of the string input
  * @param inp String which contains the users input of which character to move accross the river
  * @return int array index value of the input and if input is not valid, return -1
  */
  public static int strIndex(String inp)
  {
    if (inp.equals("N"))
    {
      return 0;
    }
    else if (inp.equals("W"))
    {
      return 1;
    }
    else if (inp.equals("S"))
    {
      return 2;
    }
    else if (inp.equals("C"))
    {
      return 3;
    }
    // if the user inputs something that is not one of the above letters, return -1
    return -1;
  }
  /**
  * Method that switches the values from 0 to 1 or 1 to 0 when a character crosses the river
  * @param arr Boolean array which contains location of each character
  * @param x Int index of the array which value dhould be switched
  */
  public static void switchVal(boolean[] arr, int x)
  {
    //if the arr[x] is false, switch it to true
    if (arr[x] == false)
    {
      arr[x] = true;
    }
    else
    {
      arr[x] = false;
    }
  }
}
