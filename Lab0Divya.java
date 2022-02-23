import java.util.Scanner;
import java.io.*;

/**
 * Lab0: Consumer Review
 * Methods for reading text files 
 * @author Divya Subramanian
 * @version 2.0
 */
public class Lab0Divya
{
  /**
  * Main Method
  * @param args The command line arguments
  */
  public static void main(String[] args)
  {
    String wordbank = readFile("sentimentValues.txt");

    // test getSentiment
    System.out.println("\nTesting getSentiment");
    System.out.println("aaron: " + getSentiment("aaron", wordbank));
    System.out.println("adjhbd: " + getSentiment("adjhbd", wordbank));
    System.out.println("zone: " + getSentiment("zone", wordbank));

    // test isLetterOnly
    System.out.println("\nTesting isLetterOnly");
    System.out.println("abcde: " + isLetterOnly("abcde"));
    System.out.println("Divya!: " + isLetterOnly("Divya!"));
    System.out.println("..dog?: " + isLetterOnly("..dog?"));

    // test removePunctuation
    System.out.println("\nTesting removePunctuation");
    System.out.println("abcde: " + removePunctuation("abcde"));
    System.out.println("Divya!: " + removePunctuation("Divya!"));
    System.out.println("..dog?: " + removePunctuation("..dog?"));

    // PART 1

    System.out.println("\nPart 1: Get Sentiment Values");

    String simpleReview = readFile("simpleReview.txt");
    System.out.println("Review = simpleReview.txt");
    double simpleReviewSent = getTotalSentiment(simpleReview, wordbank);
    System.out.format("Total Sentiment = %.2f \n", (simpleReviewSent)); //.format and %.2f allow double to have two decimal values
    System.out.println("Star Rating = " + starRating(simpleReviewSent));

    String longReview = readFile("longerReview.txt");
    System.out.println("\nReview = longerReview.txt");
    double longReviewSent = getTotalSentiment(longReview, wordbank);
    System.out.format("Total Sentiment = %.2f \n", (longReviewSent));
    System.out.println("Star Rating = " + starRating(longReviewSent));

    // PART 2
    System.out.println("\nPart 2: Generate Fake Review");
    String negativeReview = readFile("negativeReview.txt");
    String adjStrArr[] = readAdjectives("positiveAdjectives.txt") ;
    System.out.println(generateFakeReview(negativeReview, adjStrArr));
  }
  /**
   * Read a text file and store the text in a String
   * @param filename The name of the file to be read
   * @return The string containing the text
   */
  public static String readFile(String filename)
  {
    File file = new File(filename);
    String text = "";
    Scanner input = null;

    // Open the file (try/catch used in case an error occurs reading the file)
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(" Cannot open " + filename );
      System.exit(1);
    }

    // Read all the lines in the file and append to the string
    while(input.hasNextLine())
    {
      String s = input.nextLine();
      text += s;
    }

    //Return the text
    return text;
  }

  /**
   * Read a text file and store each line in an array of strings
   * @param filename The name of the file to be read
   * @return The array of strings for all lines in the file
   */
  public static String[] readAdjectives(String filename)
  {
    File file = new File(filename);
    // Hard code the number of adjectives in the array
    String[] adjectives = new String[30];

    // Open the file
    Scanner input = null;

    //try/catch used in case an error occurs reading the file
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(" Cannot open " + filename );
      System.exit(1);
    }
    // Read the adjectives one by one and store them in the array
    int n = 0;
    while(input.hasNextLine())
    {
      String s = input.nextLine();
      adjectives[n] = s;
      n++;
    }
    return adjectives;
  }

  /**
  * Takes in a word and returns the sentiment value double from wordbank and if the word is not there, it returns 0
  * @param word The string whose sentiment value is searched for
  * @param wordbank The string of list of words which contains words and their sentiment values
  * @return double The sentiment value of word
  */
  public static double getSentiment(String word, String wordbank)
  {
    word = word.toLowerCase();

    // the word could either be the first word in the wordbank so it would not have a comma before it or it is another word so I have to test the word with commas before and after (in case the word is part of another word that is in the wordbank)
    word = word + ",";
    int indexOfWord;
    // checks if word is the first word in wordbank
    if (wordbank.indexOf(word) == 0)
    {
      indexOfWord = 0;
    }
    // checks if not first word in wordbank
    else
    {
      word = "," + word;
      indexOfWord = wordbank.indexOf(word);
      // word is not in wordbank then return 0
      if (indexOfWord < 0)
      {
        return 0.0;
      }
    }

    //moves index up to start of sentiment value
    int indexOfSentiment = indexOfWord + word.length();

    String sentimentValueStr = "";

    //traverses through the sentiment value of the word until reaches next comma
    while ( indexOfSentiment < wordbank.length() && !(wordbank.substring(indexOfSentiment, indexOfSentiment + 1).equals(",")))
    {
      sentimentValueStr += wordbank.substring(indexOfSentiment, indexOfSentiment + 1);
      indexOfSentiment++;
    }
    double sentimentValueDouble = Double.parseDouble(sentimentValueStr);
    return sentimentValueDouble;
  }
  /**
  * Checks a string to see if it is composed of only letters by going through each character and comparing its ascii value to "a"
  * @param s String which is checked for letters
  * @return boolean true is returned if the string contains all letters and false is returned otherwise
  */
  public static boolean isLetterOnly(String s)
  {
    // if string is empty or null
    if (s == null || s.equals(""))
    {
      return false;
    }
    // goes through string and checks each character to see if its a letter by comparing its ascii value to "a"
    for (int x = 0; x < s.length(); x++)
    {
      String charInStr = s.substring(x, x + 1).toLowerCase();

      if (charInStr.compareTo("a") >= 26 || charInStr.compareTo("a") < 0)
      {
        return false;
      }
    }
    return true;
  }
  /**
  * Takes in a word and removes all punctuation or nonletters
  * @param word String whose punctuation is removed
  * @return String with punctuation removed
  */
  public static String removePunctuation(String word)
  {
    //loops through beginning of string and removes nonletters by taking substring one character forward
    while( (word.length() > 0) && (!isLetterOnly(word.substring(0,1))) )
    {
      word = word.substring(1);
    }

    //if the whole word is full of non-letters then the previous loop will make string have a length of 0
    if ( word.length() == 0 )
    {
      return word;
    }

    int wordLength = word.length() - 1;
    // loops thrugh end of string and removes all nonletters
    while(!isLetterOnly(word.substring(wordLength,wordLength + 1)))
    {
      word = word.substring(0, wordLength);
      wordLength = word.length() - 1;
    }
    return word;
  }
  /**
  * Takes in a review and wordbank and calculates sum of the sentiment values of all words in the review
  * I approached this problem by using spaces as a delimiter to separate out words. A problem that I had was taking the last word because there was no space following it.
  * @param review String with words whose sentiment values will be summed and returned
  * @param wordbank String of list of words with each of their sentiment values
  * @return Double sum of sentiment values of all words in review
  */
  public static double getTotalSentiment(String review, String wordbank)
  {
    double sentimentSum = 0.0;
    int index = 0;
    int nextSpace;
    // continues looping until reaches end of the string
    while (index < review.length())
    {
      // uses spaces to find next word
      int distanceToNextSpace = (review.substring(index)).indexOf(" ");
      // case: there is no next space because it is last word in string
      if (distanceToNextSpace < 0)
      {
        nextSpace = review.length();
      }
      else
      {
        nextSpace = index + distanceToNextSpace;
      }
      String word = review.substring(index, nextSpace);

      word = removePunctuation(word);

      if (word.length() >= 1 && isLetterOnly(word))
      {
        sentimentSum += getSentiment(word, wordbank);
      }
      // index moves up by 1 to start next word
      index = nextSpace + 1;
    }

    return sentimentSum;
  }
  /**
  * Takes in a double and returns the corresponding star rating
  * @param sentiment A double whose value is used to determine star rating
  * @return int of star rating
  */
  public static int starRating(double sentiment)
  {
    if (sentiment < -10.0)
    {
      return 0;
    }
    else if (sentiment >= -10.0 && sentiment < 0.0)
    {
      return 1;
    }
    else if (sentiment >= 0.0 && sentiment < 10.0)
    {
      return 2;
    }
    else if (sentiment >= 10.0 && sentiment < 20.0)
    {
      return 3;
    }
    // sentiment >= 20
    return 4;
  }
  /**
  * Takes in a word and removes and stores and returns the end punctuation
  * As seen in the text cases, sometimes there was more than 1 punctuation that had to be extrated so I made this recursive (could have also been done by loop)
  * @param word The string that is inputted whose punctuation is extracted
  * @preturn String of punctuation that was extracted
  */
  public static String extractPunctuation(String word)
  {
    int wdLength = word.length() - 1;
    String lastChar = word.substring(wdLength, wdLength + 1);
    // checks if last char is a letter
    if(isLetterOnly(lastChar))
    {
      return "";
    }
    //recursively calls function until last character in string is a letter
    return extractPunctuation(word.substring(0, wdLength)) + lastChar;
  }
  /**
  * Takes in a review and replaces all words following a star with a random adjective from adjective string array
  * Similar to getTotalSentiment, a problem I faced in this function was that the last word does not have a space following it so I had to make a separate test case
  * @param review String which contains a review whose negative adjectives are substituted for positive adjectives
  * @param posAdj An array which contains strings of posititve adjectives
  * @return String The fake review which was taken from the review and had words with a preceding star switched out for random positive adjectives
  */
  public static String generateFakeReview(String review, String[] posAdj)
  {
    int indexOfStar = 0;
    // loops through until there are no more words with * before
    while ((indexOfStar = review.indexOf("*")) > 0)
    {
      int distanceToNextSpace = (review.substring(indexOfStar)).indexOf(" ");
      int indexOfSpace;
      // this means that the word is a the end of the string with no space following it so the end index is set to the last element in the string review
      if (distanceToNextSpace < 0)
      {
        indexOfSpace = review.length();
      }
      //there is a space following the *
      else
      {
        indexOfSpace = indexOfStar + distanceToNextSpace;
      }

      // takes word from right after star to right before the space - this may include punctuation
      String word = review.substring(indexOfStar + 1, indexOfSpace);
      String punctuation = extractPunctuation(word);

      // chooses a random number within the length of the string
      int randElement = (int) (Math.random() * posAdj.length);
      review = review.substring(0, indexOfStar) + posAdj[randElement] + punctuation + review.substring(indexOfSpace);
    }
    return review;
  }
}
