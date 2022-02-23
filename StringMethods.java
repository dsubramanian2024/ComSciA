public class StringMethods
{
  public static void main(String[] args)
  {
    String firstName = "Divya";
    String phrase = "Mary had a little lamb";
    String phrase2 = "ABC";
    int idx;
    int nameLength;


    System.out.println(firstName.length());
    nameLength = firstName.length();

    System.out.println(phrase.substring(5,8));

  }
  public static int findString(String o, String s, int start)
  {
    return o.indexOf(s, start);
  }
}
