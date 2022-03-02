/**
* Class of a Basket which contains a variety of fruits
* @author Divya
* @version 1.0
*/
public class Basket
{
  //each basket has a specified color and contains 3 fruits
  String basketColor;
  Fruit fruit1;
  Fruit fruit2;
  Fruit fruit3;

  //keeps track of number of baskets made
  static int numOfBaskets = 0;

  /**
  * constructor in which no variables are inputted so it is set by function
  */
  public Basket()
  {
    this("brown", new Fruit("apple", "red"), new Fruit("kiwi", "green"), new Fruit("banana", "yellow"));
  }

  /**
  * constructor in which all variables are inputted
  */
  public Basket(String color, Fruit a, Fruit b, Fruit c)
  {
    basketColor = color;
    fruit1 = a;
    fruit2 = b;
    fruit3 = c;
  }

  /**
  * Method to return the basket color
  * @return String basketColor
  */
  public String getBasketColor() {return basketColor;}

  /**
  * Method to return fruit1
  * @return fruit1
  */
  public Fruit getFruit1() {return fruit1;}

  /**
  * Method to return fruit2
  * @return fruit2
  */
  public Fruit getFruit2() {return fruit1;}

  /**
  * Method to return fruit3
  * @return fruit3
  */
  public Fruit getFruit3() {return fruit1;}

  /**
  * Method to return the number of baskets
  * @return int which is number of baskets
  */
  public static int getNumofBaskets() {return numOfBaskets;}

  /**
  * Method to set the color of the basket
  * @param s name of basket
  */
  public void setBasketColor(String s) {basketColor = s;}

  /**
  * Method to set fruit1
  * @param f fruit to set fruit1 with
  */
  public void setFruit1(Fruit f) {fruit1 = f;}

  /**
  * Method to set fruit2
  * @param f fruit to set fruit2 with
  */
  public void setFruit2(Fruit f) {fruit2 = f;}

  /**
  * Method to set fruit3
  * @param f fruit to set fruit3 with
  */
  public void setFruit3(Fruit f) {fruit3 = f;}

  /**
  * Method to make the basket in to a String
  * @return String which contains the color and three fruits
  */
  public String toString()
  {
    String customPrint =  "color: " + basketColor + "\nFruit 1: \n" + fruit1 + "\nFruit 2: \n" + fruit2 + "\nFruit 3: \n" + fruit3;
    return customPrint;
  }

  /**
  * Method to create a string with a note to the reciever about what is in the basket
  * @param receiver person who basket is being sent to
  * @return String message sent to reciever
  */
  public String sendABasket(String reciever)
  {
    return "sent";
  }

  /**
  * Method to see how many of a certain fruit are in a basket
  * @param fruitName this string is compared to the names of the three fruits in the basket and the number of mathches with fruitName is the number that is returned
  * @return int number of occurences of fruitName in the basket
  */
  public int numberOfTypeOfFruit(String fruitName)
  {
    return 0;
  }

}
