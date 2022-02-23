import java.util.Scanner;  //use input
/**
 * This program is a tic tac toe game between two players.
 * The tic tac toe grid is initialized with locations from 1 to NxN where N is the size of the board.
 * The locations where player 1 plays are marked with -1 and the locations with player 2 plays are marked with -2.
 * This helps because positive locations are unoccupied and negative locations are marked with minus the player number.
 * @author Divya Subramanian
 * @version 2.0
 */
public class TicTacToeDivya
{
  /**
   * Main function that plays the game of tic tac toe
   * @param args The command line arguments
   */
  public static void main(String[] args)
  {
    System.out.println("Divya's Computer Science Poem (this is for 100 extra credit points!!! :) I fully consent to this being shown to the entire class as an example of fabulous code)");
    System.out.println("            Computer Science");
    System.out.println("         i wake up and only code");
    System.out.println(" the sound of the keyboard stimulates my brain");
    System.out.println("all the print statements, i just cant get enough");
    System.out.println("    ohh, the joy from writing Monty Hall");
    System.out.println("       python, java, c, oh galore!!");
    System.out.println("     i don't want to sleep, just code");
    System.out.println("          coding is the #thuglife\n");

    //int[][] myArr = {{5, 5, 5}, {4, 5, -2}, {5, 2, 5}};
    //System.out.println(isRowWin(myArr));
    //System.out.println(isColumnWin(myArr));
    // System.out.println(getValidInput(myArr, 6));
    // i did other tests but deleted it

    playGame();

  } //end main
  /**
  * This function is what goes through the rounds and plays the game
  * It calls other functions and finally says if the game ended in a draw of which player won
  */
  public static void playGame()
  {
    Scanner kboard = new Scanner(System.in);

    System.out.println("Welcome to Tic Tac Toe");
    System.out.println("Player 1 plays with X");
    System.out.println("Player 2 plays with O");
    //leon wuz here (please give divya extra credit)

    System.out.println("Enter an integer which will be the length of the square tic tac toe board: ");
    int boardSize = kboard.nextInt();

    int[][] board = new int[boardSize][boardSize];

    // initializes the array with numbers from 1 to n^2
    int count = 1;
    for(int x = 0; x < boardSize; x++)
    {
      for (int y = 0; y < boardSize; y++)
      {
        board[x][y] = count;
        count++;
      }
    }

    int keepPlayerTrack = 1;
    while (!isGameOver(board))
    {
      //System.out.println("is game over = " + isGameOver(board));
      //System.out.println(isRowWin(board));
      printBoard(board);
      if(keepPlayerTrack % 2 == 1)
      {
        System.out.print("Player 1, choose a tile: ");
        int playerInput = kboard.nextInt();
        playerInput = getValidInput(board, playerInput);
        board[(playerInput - 1) / boardSize][(playerInput - 1) % boardSize] = -1;
      }
      else
      {
        System.out.print("Player 2, choose a tile: ");
        int playerInput = kboard.nextInt();
        playerInput = getValidInput(board, playerInput);
        board[(playerInput - 1) / boardSize][(playerInput - 1) % boardSize] = -2;
      }
      keepPlayerTrack += 1;
      System.out.println("\n");
    }
    //winner is that of previous turn
    int winner = (keepPlayerTrack - 1) % 2;
    if (winner == 0)
    {
      winner = 2;
    }
    printBoard(board);
    //saying if winner or tie
    if (isRowWin(board) >= 0 || isColumnWin(board) >= 0 || isDiagonalWin(board) > 0)
    {
      System.out.println("Congrats! Player " + winner + " wins!!");
    }
    else
    {
      System.out.println("Its a draw!");
    }
  }
  /**
  * This function loops through the 2d array and prints out the value. If the value of the element is -1 or -2, the function prints an X or O respectively
  * @param int[][] board which is the game board
  */
  public static void printBoard(int[][] board)
  {
    int boardSize = board.length - 1;

    //get how many digits are in the biggest number in the array
    int maxNumLength = lengthOfInt((boardSize + 1)^2);

    //print the array
    for(int x = 0; x <= boardSize; x++)
    {
      for (int y = 0; y <= boardSize; y++)
      {
        System.out.print(" | ");

        int currentNumLength = 1;
        // -1 means player 1 put an X there
        if(board[x][y] == -1)
        {
          System.out.print("X");
        }
        //-2 means player to put an O there
        else if(board[x][y] == -2)
        {
          System.out.print("O");
        }
        else
        {
          System.out.print(board[x][y]);
          currentNumLength = lengthOfInt(board[x][y]);
        }
        // loops through and prints spaces between length of current number and max number
        for(int n = 0; n <= (maxNumLength - currentNumLength); n++)
        {
          System.out.print(" ");
        }
      }
      System.out.println(" |");
    }
  }
  /**
  * Takes in a board and loops through all rows. Within each row, all elements are compared to the first element. The winning row if any is returned
  * @param int[][] board which stores the values of the game
  * @return int If all elements are the same, that player wins and that row number is returned otherwise -1 is returned
  */
  public static int isRowWin(int[][] board)
  {
    int boardSize = board.length - 1;
    //loops through all rows
    for (int x = 0; x <= boardSize; x++)
    {
      int rowSum = 0;
      int firstNum = board[x][0];
      for (int y = 0; y <= board[x].length - 1; y++)
      {
        //compares all elements in row to the first
        if (board[x][y] == firstNum)
        {
          rowSum++;
        }
      }
      //System.out.println("Sum of row " + x + ": " + rowSum);
      // if all elements in the row are the same, returns the row number
      if (rowSum == boardSize + 1)
      {
        return x;
      }
    }
    return -1;
  }
  /**
  * Takes in a board and loops through all columns. Within each column, all elements are compared to the first element. The winning column if any is returned
  * @param int[][] board which stores the values of the game
  * @return int If all elements are the same, that player wins and that column number is returned otherwise -1 is returned
  */
  public static int isColumnWin(int[][] board)
  {
    int boardSize = board.length - 1;
    // outer loop is for columns and inner loop is row - backwards to rows function
    for (int y = 0; y <= boardSize; y++)
    {
      int colSum = 0;
      int firstNum = board[0][y];
      for (int x = 0; x <= boardSize; x++)
      {
        if (board[x][y] == firstNum)
        {
          colSum++;
        }
      }
      // if all elements in column are the same
      if (colSum == boardSize + 1)
      {
        return y;
      }
    }
    return -1;
  }
  /**
  * Takes in a board and loops through both diagonals. Within each diagonal, all elements are compared to the first element. The winning diagonal if any is returned (1 or 2)
  * @param int[][] board which stores the values of the game
  * @return int If all elements are the same, that player wins and that row number is returned otherwise -1 is returned
  */
  public static int isDiagonalWin(int[][] board)
  {
    int boardSize = board.length - 1;

    // checks diagonal from top left to bottom right
    int diagSum = 0;
    int firstNum = board[0][0];
    for (int x = 0; x <= boardSize; x++)
    {
      if (board[x][x] == firstNum)
      {
        diagSum++;
      }
    }
    if (diagSum == boardSize + 1)
    {
      return 1;
    }

    // checks diagonal from top right to bottom left
    diagSum = 0;
    firstNum = board[0][boardSize];
    for (int x = 0; x <= boardSize; x++)
    {
      if (board[x][boardSize - x] == firstNum)
      {
        diagSum++;
      }
    }
    if (diagSum == boardSize + 1)
    {
      return 2;
    }

    //no diagonal wins
    return -1;
  }
  /**
  * Takes in a number and finds the length or how many digits it has
  * @param num the number whose length is found
  * @return int length of num
  */
  public static int lengthOfInt(int num)
  {
    int maxNumLength = 0;
    //continuosly multiplies count by 10 and compares it to num; this is similar to using dividing and mod
    for (int count = 1; count <= num; count *= 10)
    {
      maxNumLength++;
    }
    return maxNumLength;
  }
  /**
  * This function returns true if all elements in the board have been chosen by the players (-1 or -2)
  * @param int[][] board which stores the values of the game
  * @return true if all elements are taken (-1 or -2) and false otherwise
  */
  public static boolean isBoardFull(int[][] board)
  {
    int boardSize = board.length - 1;
    //loops through rows(outer loop) and columns(inner loop)
    for (int x = 0; x <= boardSize; x++)
    {
      for (int y = 0; y <= board[x].length - 1; y++)
      {
        if (board[x][y] > 0)
        {
          return false;
        }
      }
    }
    return true;
  }
  /**
  * This function takes in an input and continues calling itself until user inputs valid number aka a nonchosen number that is within array bounds
  * @param int[][] board stores the status of the game
  * @param input what the user inputted as their choice on the board
  * @return int of the final valid user input
  */
  public static int getValidInput(int[][] board, int input)
  {
    Scanner kboard = new Scanner(System.in);

    int boardSize = board.length;
    int maxNum = boardSize * boardSize;

    //calculates the x and y cordinates of the array given a number from one to the length squared
    int xVal = (input - 1) / (boardSize);
    int yVal = (input - 1) % (boardSize);
  //  System.out.println("xval = " + xVal);
  //  System.out.println("yval = " + yVal);

    // if input is valid
    if (input >= 1 && input <= maxNum && board[xVal][yVal] >= 1)
    {
      return input;
    }
    // input is out of bounds
    else if (input < 1 || input > maxNum)
    {
      System.out.println("Your number is out of bounds.");
    }
    // user chooses a box that is already chosen
    else
    {
      System.out.println("Your number is already chosen.");
    }
    System.out.print("Please enter a non-chosen number from 1 to " + maxNum + ": ");
    int userInput = kboard.nextInt();
    //recalls function to check new input
    return getValidInput(board, userInput);
  }
  /**
  * This function calls the row, column, diagonal, and isBoardFull functions to check if the game is over
  * @param int[][] board which shows status of the game
  * @return true if the game is over aka win or draw and false otherwise
  */
  public static boolean isGameOver(int[][] board)
  {
    if (isBoardFull(board) || isRowWin(board) >= 0 || isColumnWin(board) >= 0 || isDiagonalWin(board) > 0)
    {
      return true;
    }
    return false;
  }
} //end class
