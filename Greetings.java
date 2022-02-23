/*
* Small program to greet the user
* Divya Subramanian
* CSA - Block 6
* Greetings.java
*/

import java.util.Scanner;

public class Greetings
{
  public static void main(String[] args)
  {
    // Declare variables for storing into from keyboard
    String userName;
    int siblings;
    int myAge;

    // declare an object instance of the scanner class
    Scanner keyboard = new Scanner(System.in);

    //Ask the user what their name is and capture the response
    System.out.print("What is your name? ");

    // capture response
    userName = keyboard.nextLine();

    // Ask another question
    System.out.print("How many siblings do you have? ");
    siblings = keyboard.nextInt();

    keyboard.nextLine();

    //another question
    System.out.print("How old are you? ");
    myAge = keyboard.nextInt();

    keyboard.nextLine();

    System.out.println("Hello " + userName);
    System.out.println("Welcome to Java! \nSay hello to your " + siblings + " siblings.");

    // test the users age and display a certain message
    if(myAge >= 18)
    {
      System.out.println("Congrats you're an adult!");
    }
    else if(myAge >= 14)
    {
      System.out.println("ur a highschooler. :(");
    }
    else
    {
      System.out.println("HOLA NINOS!");
    }

  }
}
