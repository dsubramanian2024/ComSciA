public class BasketRunner
{
  public static void main(String[] args)
  {
    System.out.println("TESTING FRUIT");

    Fruit fruit1 = new Fruit();
    Fruit fruit2 = new Fruit("banana", "yellow");

    String fruitName = "pear";
    String fruitColor = "brown";

    //printing variables of fruit1
    System.out.println("Fruit 1: ");
    System.out.println(fruit1.getName());
    System.out.println(fruit1.getColor());
    System.out.println(fruit1);

    //setting fruit1 variables and printing new ones
    System.out.println("Changing fruit 1 name and color to pear and brown ");
    fruit1.setColor(fruitColor);
    fruit1.setName(fruitName);

    System.out.println(fruit1.getName());
    System.out.println(fruit1.getColor());

    //printing variables of fruit 2
    System.out.println("Fruit 2: ");
    System.out.println(fruit2.getName());
    System.out.println(fruit2.getColor());

    //printing number of fruits
    System.out.println("Number of instances of fruit: " + Fruit.getNumberofFruits());

    //using equals function to see if name and color are the same
    System.out.println("are fruit 1 and 2 equal? : " + fruit1.equals(fruit2));

    //testing basket now
    System.out.println("\n\n\nTESTING BASKET");

    Basket myBasket = new Basket("brown", fruit1, fruit2, new Fruit("grapefruit", "pink"));
    System.out.println("\nBasket: \n" + myBasket);

    //setting first fruit to be a new fruit with standardized name and color
    myBasket.setFruit1(new Fruit());

    //printing number of baskets
    System.out.println("Number of baskets: " + Basket.getNumofBaskets());

    System.out.println("\nFruit 1 using getter: \n" + myBasket.getFruit1());

  }
}
