/**
* This is a chatbot that talks back to you
* Divya Subramanian
* Block 6
* ChatbotV2
*/
import java.util.Scanner;
public class ChatbotV2
{
  public static void main (String[] args)
  {
    // Creating a scanner object to get the input from the keyboard
    Scanner kboard = new Scanner(System.in);
    // Asking the user for their name
    System.out.print("Please enter your name: ");
    String name = kboard.nextLine();
    // Greeting the user
    System.out.print("Hi " + name + "! How are you doing? ");
    String input = kboard.nextLine();
    System.out.println("I am glad that you are " + input);
    // Asking the user for their age
    System.out.print("So, " + name + ", how old are you? ");
    int age = kboard.nextInt();
    // Remember what happens if you forget this line
    kboard.nextLine();
    // Asking the user one more question based on their age
    if (age > 25)
    {
      System.out.println("Wow ur old. ");
    }
    else if (age > 5)
    {
      System.out.println("still stuck in school :( ");
    }
    else
    {
      System.out.println("NAP TIME? ");
    }

    System.out.print("What do you want to talk about? ");
    String response = kboard.nextLine();

    //keeps looping through until the user enters 'bye'
    while (!response.contains("bye"))
    {
      if (response.contains("weather"))
      {
        System.out.println("The weather is sunny this weekend!");
      }
      else if (response.contains("homework"))
      {
        System.out.println("Be efficient and get your work done!");
      }
      else if (response.contains("school"))
      {
        System.out.println("Don't forget, friday is a dress up day!");
      }
      else if (response.contains("sport"))
      {
        System.out.println("Tennis is my favorite sport!");
      }
      else
      {
        System.out.println("Sorry, I don't know what that is. ");
      }
      System.out.print("What else do you want to talk about? ");
      response = kboard.nextLine();
    }

  }
}
