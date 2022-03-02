/**
* Class of a fruit which has a color and name
* @author Divya
* @version 1.0
*/
public class Fruit
{
  //each fruit has a color and a name
  private String name;
  private String color;

  //part of the object and keeps track of number of instances of the fruit
  static int numberOfFruits = 0;

  /**
  * constructor in which no parameters are inputted so Fruit has name Apple and color Red
  */
  public Fruit()
  {
    //calls the following function which sets the values of this to be Apple and Red
    this("Apple", "Red");
  }

  /**
  * constructor in which both variables are inputted
  */
  public Fruit(String fruitName, String fruitColor)
  {
    color = fruitColor;
    name = fruitName;

    //increments fruit count
    numberOfFruits++;
  }

  /**
  * Method to return the name
  * @return String which is the  name
  */
  public String getName() {return name;}

  /**
  * Method to return the color
  * @return String which is the color of the fruit
  */
  public String getColor() {return color;}

  /**
  * Method to return the number of fruits
  * @return int which is number of fruits
  */
  public static int getNumberofFruits() {return numberOfFruits;}


  /**
  * Method to set the name of the fruit
  * @param n name of the fruit
  */
  public void setName(String n) {name = n;}

  /**
  * Method to set the color of the fruit
  * @param c color of the fruit
  */
  public void setColor(String c) {color = c;}

  //cannot set the numberOfFruits variable bc is is static

  /**
  * Method to make a string out of the color and name
  * @return String which contains the name and color of the fruit in nicer format
  */
  public String toString()
  {
    String customPrint = "name: " + this.name + "\ncolor: " + this.color;
    return customPrint;
  }

  /**
  * Method to see if two fruits are equal - they are equal if their name and color are the same
  * @param b Fruit that the other fruit is being compared to
  * @return true if both name and color for both fruit are the same and false otherwise
  */
  public boolean equals(Fruit b)
  {
    //checking if both name AND color are the same for both fruit
    return (this.name == b.name) && (this.color == b.color);
  }

}
