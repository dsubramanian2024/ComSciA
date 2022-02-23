/**
 * Lab 1: Blackjack
 * In this lab, I made a basic black jack simulation and used the odds calculated to make a simple game with a automated player
 * I don't think this lab was as hard as the other especially since there is no user input which might throw an error.
 * Something that was hard was making sure the last element in the deck is not shuffled and sores the card position
 * @author Divya Subramanian
 * @version 2.0
 */
public class Lab1Divya
{
  // Global variables
  // count counts the number of times a given sum is obtained during simulations
  // safe counts the number of times the player is safe after hitting from a given sum
  public static int[] count = new int[21];
  public static int[] safe = new int[21];
  /**
  * Main Method
  * @param args The command line arguments
  */
  public static void main(String[] args)
  {
    int[] deck = buildDeck();
    System.out.print("unshuffled deck: ");
    printArray(deck);

    shuffle(deck);
    System.out.print("\nshuffled deck: ");
    printArray(deck);

    simulate(deck, 10000);
    double[] odds = calculateOdds();
    System.out.print("\nodds array: ");
    printArray(odds);
    //System.out.println(shouldIHit(14, odds));
    //System.out.println(shouldIHit(26, odds));
    System.out.println("\n");
    playDealer(deck, odds);

  }

  /**
   * Function to print an array of double
   * @param arr is the array to print
   */
  public static void printArray(double[] arr)
  {
    System.out.print("[");
    for(int i = 0; i < arr.length - 1; i++)
      System.out.format("%.2f, ", arr[i]);
    System.out.format("%.2f]", arr[arr.length - 1]);
  }

  /**
   * Function to print an array of int
   * @param arr is the array to print
   */
  public static void printArray(int[] arr)
  {
    System.out.print("[");
    for(int i = 0; i < arr.length - 1; i++)
      System.out.print(arr[i] + ", ");
    System.out.println(arr[arr.length - 1] + "]");
  }
  /**
  * Has no parameters and returns a new deck, in order, in which the suit does not matter
  * I approached this by having a loop within another loop so that each number comes up 4 times other than 10
  * @return An int array of the new, unordered deck with a 0 in the 52nd index
  */
  public static int[] buildDeck()
  {
    int[] deck = new int[53];
    int count = 0;
    // will loop through numbers all values in deck
    for (int num = 1; num <= 13; num++)
    {
      // each of those numbers inputted 4 times in the array (bc all of the suits)
      for (int numInstance = 1; numInstance <= 4; numInstance++)
      {
        // 10, jack, queen, and king are all equal to 10 so 16 10s have to be added to the array
        if (num > 9)
        {
          deck[count] = 10;
        }
        else
        {
          deck[count] = num;
        }
        count++;
      }
    }
    // last element is a 0 in which index of top card is stored
    deck[52] = 0;
    return deck;
  }
  /**
  * Takes in a deck of cards and shuffles all elements except last element
  * I approached this by looping through all elements in the deck(except the last one) and switching its value with a randomly chosen other element
  * @param int[] of card deck
  */
  public static void shuffle(int[] deck)
  {
    for (int index = 0; index <= 51; index++)
    {
      //everything but last element
      int randElement = (int) (Math.random() * (51 - index)) + index;
      // switches value of deck[randELement] and deck[index]
      int holder = deck[index];
      deck[index] = deck[randElement];
      deck[randElement] = holder;
    }
  }
  /**
  * Return the top card and increment the top card variable, unless
  * you have hit the end of the array. In that case, shuffle the deck
  * and set the top card variable to 0.
  * @param int[] of card deck
  */
  public static int getCard(int[] deck)
  {
    // shuffles deck when last element >= 51
    if (deck[52] >= 51)
    {
      shuffle(deck);
      // resets value
      deck[52] = 0;
    }
    // stored valye of last index
    int topCardPlacement = deck[52];
    deck[52] += 1;
    return deck[topCardPlacement];
  }
  /**
  * Given a deck, will play one hand of BlackJack and record the number of times you get the value and the number of times you are safe when you hit at that value
  * I constantly looped through until score exceeds 21 and added to arrays which stored safe and count
  * @param deck Int array of value of deck of cards
  */
  public static void playHand(int[] deck)
  {
    int score = 0;
    // has to give user two cards
    score += getCard(deck);
    score += getCard(deck);

    // keeps looping until score exceeds 21 (making score invalid)
    while (score < 21)
    {
      int topCard = getCard(deck);
      if (score + topCard <= 21)
      {
        safe[score] += 1;
      }
      count[score] += 1;
      score += topCard;
    }
  }
  /**
  * Takes in a deck and uses it to simulate numTimes different hands by calling playHand
  * @param deck Int array of the card deck
  * @param numTimes Int number of times simulation is run
  */
  public static void simulate(int[] deck, int numTimes)
  {
    for (int index = 0; index < numTimes; index++)
    {
      playHand(deck);
    }
  }
  /**
  * calculates odds of being safe for each value by looping through the array and dividing the number of safe instances by total
  * @return double[] which stores all the odds
  */
  public static double[] calculateOdds()
  {
    double[] safetyOddsArr = new double[21];
    // elements 0 and 1 will always have a value of 0 because the sum of two cards will always be 2 or higher
    for (int x = 2; x <= 20; x++)
    {
      safetyOddsArr[x] = (double) safe[x] / count[x];
    }
    return safetyOddsArr;
  }
  /**
  * Returns whether or not you should hit, based on your current odds.
  * I approached this by making a random double from 0 to 1 and using this value and comparing it to the odds
  * @param currVal int of what sum the player is at
  * @param odds double[] of all odds after calculating odds in calculateOdds
  * @return boolean true if player should hit and false if player shouldn't based on odds
  */
  public static boolean shouldIHit(int currVal, double[] odds)
  {
    // if currVal out of bounds
    if (currVal > 21 || currVal < 0)
    {
      return false;
    }
    double randomNum = Math.random();
    double probability = odds[currVal];
    // compares random generated number to number in odds array
    if (randomNum < probability)
    {
      return true;
    }
    return false;
  }
  /**
  * The dealer gets one card and then the player gets two. The player continues to get card using shouldIHit until it returns false or player busts. Then the dealer keeps drawing cards while their score is less than 17
  * I approached this by using while loops.
  * @param deck Int[] of cards
  * @param odds double[] storing probabiliy with which user is safe when at a certain value
  */
  public static void playDealer(int[] deck, double[] odds)
  {
    //dealer gets one card at the beginning
    System.out.println("Playing against the dealer");
    int dealerScore = 0;
    int dealerCard = getCard(deck);
    System.out.println("Dealer gets: " + dealerCard);
    dealerScore += dealerCard;
    System.out.println("Current dealer hand: " + dealerScore);

    //player gets 2 cards at the beginning
    int playerScore = 0;
    int playerCard = getCard(deck);
    playerScore += playerCard;
    System.out.println("Player gets: " + playerCard);
    playerCard = getCard(deck);
    playerScore += playerCard;
    System.out.println("Player gets: " + playerCard);
    System.out.println("Current player hand: " + playerScore);

    // player can hit as many times as decided by shouldIHit and will continue until total score exceeds 21 or shouldIhit returns false
    while(playerScore < 21)
    {
      if(shouldIHit(playerScore, odds))
      {
        playerCard = getCard(deck);
        System.out.println("Player gets: " + playerCard);
        playerScore += playerCard;
      }
      // shouldIhit returns false so player stays
      else
      {
        break;
      }
    }

    System.out.println("Current player hand: " + playerScore);
    // player busts so dealer wins and game is over
    if(playerScore > 21)
    {
      System.out.println("Player busts and Dealer wins!");
      //exits function
      return;
    }
    // otherwise if the playerScore <= 21
    System.out.println("Player stays");

    // dealer continues to get cards until their score is 17 or higher
    while (dealerScore <= 16)
    {
      dealerCard = getCard(deck);
      System.out.println("Dealer gets: " + dealerCard);
      dealerScore += dealerCard;
    }
    System.out.println("Current dealer hand: " + dealerScore);

    // player wins when dealer busts or if player has higher score
    if (dealerScore > 21 || playerScore > dealerScore)
    {
      System.out.println("Player wins!");
    }
    // if both player and dealer score the same, its a push
    else if (dealerScore == playerScore)
    {
      System.out.println("Push - tie");
    }
    // otherwise dealer wins
    else
    {
      System.out.println("Dealer wins!");
    }
  }

}
