/*
* Monty Hall game
* Divya Subramanian
* CSA - Block 6
* MontyHall.java
*/

import java.util.Scanner;
import java.util.Random;

public class MontyHall
{
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);
    // introduction to game
    System.out.println("Welcome! This is the Monty Hall game! \nThere will be three doors. Behind one of the doors will be a car and behind the other two will be a goat. You will choose a door by entering 1, 2, or 3 and then I will open a door that has a goat. You will be given the choice of whether you want to switch or keep the same door. Finally, you will be shown what was behind your chosen door. Have fun! ");

    //randomly choosing a door to have the goat
    int car = (int)((Math.random() * 3) + 1);

    //get the door the user wants
    int choice = getPosition();

    //open a door with a goat
    int reveal = revealDoor(choice, car);
    System.out.println("Door " + reveal + " has a goat.");

    //ask if they want to switch
    String flip;
    System.out.print("Do you want to switch your door? y or n:  ");
    flip = kboard.nextLine();
    if (flip.equals("y"))
      choice = revealDoor(choice, reveal);

    //show result
    if (car == choice)
      System.out.println("Yay! You chose the door with the car! :) \n");
    else
      System.out.println("Oh no! You chose a door with a goat. Door " + car + " had the car. :( \n");
  }

  public static int getPosition() //has the user choose a door (between 1 and 3) and does error handling
  {
    System.out.print("What door do you want to choose? Type either 1, 2, or 3:  ");
    Scanner kboard = new Scanner(System.in);
    int response = kboard.nextInt();

    if (response >= 1 && response <= 3)
      return response;
    System.out.println("Sorry, that is not a valid response. Please re-enter. ");
    return getPosition();
  }
  public static int revealDoor(int door1, int door2) //opens a door that is not doorA or doorB
  {
    int reveal;
    do {
      reveal = (int) (Math.random() * 3) + 1;
    } while ((reveal == door1) || (reveal == door2));
    return reveal;
  }
}
