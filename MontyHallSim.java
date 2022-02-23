/*
* Monty Hall Simulation
* Divya Subramanian
* CSA - Block 6
* MontyHallSim.java
*/
import java.util.Scanner;
import java.util.Random;

public class MontyHallSim
{
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);
    System.out.print("How many trials do you want to run?  ");
    int trial = kboard.nextInt();
    int stayW = 0; //keeps track of number of times user stays and wins

    //loops for the number of trials inputted
    for (int i = 1; i <= trial;  i++)
    {
      int car = getPosition(); // randomly chooses door with car
      int choice = getPosition(); //simulates users choice by randomly choosing door

      if (choice == car)
        stayW++; //if choice is car, the user wins by staying (not switching)
    }
    // prints out number of trials and percents won for staying and switching
    System.out.println("Trials won by staying: " + stayW);
    System.out.println("Trials won by switching: " + (trial - stayW));
    System.out.println("Percent of trials won by staying: " + String.format("%.2f",(100.0 * stayW / trial)) + "%");
    System.out.println("Percent of trials won by switching: " + String. format("%.2f",(100.0 * (trial - stayW) / trial)) + "%");
  }

  public static int getPosition()
  { //randomly chooses a door
    return (int)((Math.random() * 3) + 1);
  }
}
