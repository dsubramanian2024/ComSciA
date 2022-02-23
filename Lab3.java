import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * Lab to implement a simplified version of the Enigma machine
 * Only 2 rotors and a backplate are used to encrypt and decrypt messages
 * Suprisingly I found making the decrypt message function to be harder than the encrypt function. I originally wrote the decrypt function wrong. Overall all I think this lab was easier than before
 * I worked on add more comments and better spacing my code like the last lab
 * @author Divya Subramanian
 * @version 2.0
 */
public class Lab3
{
	// Global variables for the rotors and backplate - DO NOT MODIFY
	public static ArrayList<Integer> rotor1 = new ArrayList<Integer>(100);
	public static ArrayList<Integer> rotor2 = new ArrayList<Integer>(100);
	public static ArrayList<Integer> backplate = new ArrayList<Integer>(100);


	/** Main function
	 * @param args command line arguments
	 *     args[0] - input filename
	 *     args[1] - starting ASCII for rotor 1
	 *     args[2] - starting ASCII for rotor 2
	 *     args[3] - starting ASCII for backplate
	 *     args[4] - output filename for encrypted message
	 *     args[5] - output filename for decrypted message
	 */
	public static void main(String args [])
	{
			//Verify the correct number of arguments were provided, if not send message and stop program
			if (args.length != 6)
			{
				System.out.println("The correct number of arguements was not inputted.");
			}
			else
			{
				//And if so, read command line argurments and store the values
				//Arguments can be read by using the "args" array for the main method
				String inputFilename = args[0];
				int rotor1Start = Integer.parseInt(args[1]);
				int rotor2Start = Integer.parseInt(args[2]);
				int backplateStart = Integer.parseInt(args[3]);
				String encryptOutputFilename = args[4];
				String decryptOutputFilename = args[5];

				//if the inputs for the start posititons of the rotors are out of bounds, message is displayed and code stops
				if (initializeRotors(rotor1Start, rotor2Start, backplateStart) == false)
				{
					System.out.println("Your rotor/backplate inputs were out of bounds. Make sure they all are between 32 and 126");
				}
				else
				{
					//Read the text file and convert the text to a list of ASCII codes
					//This uses the provided readFile() method
					//The next line of code has been intentionally excluded

					ArrayList<Integer> input = new ArrayList<Integer>(1000);
					ArrayList<Integer> outputEncrypt = new ArrayList<Integer>(1000);
					ArrayList<Integer> outputDecrypt = new ArrayList<Integer>(1000);

					readFile(inputFilename, input);
					//System.out.println("The converted text of input: " + input);

					//call encrypt function and write to file
					encryptMessage(input, outputEncrypt);
					System.out.println("Writing file: ");
					writeFile(encryptOutputFilename, outputEncrypt);

					//reinitializes rotors
					initializeRotors(rotor1Start, rotor2Start, backplateStart);

					//cell decrypt function and write
					decryptMessage(outputEncrypt, outputDecrypt);
					System.out.println("Writing file: ");
					writeFile(decryptOutputFilename, outputDecrypt);
				}
			}
	}

  /**
	 * Read a text file and convert the text to a list of ASCII codes
	 * @param filename The name of the file to be read
	 * @param list The resulting list containing the read text in ASCII code
   */
	public static void readFile(String filename, ArrayList<Integer> list)
	{
		list.clear();
		File file = new File(filename);
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + filename );
			System.exit(1);
		}
		while(input.hasNextLine())
		{
			String s = input.nextLine();
			for(int i = 0; i < s.length(); i++)
				list.add((int)s.charAt(i));
		}
	}


	/**
	 * Writes an Array List of Integer as a text file
	 * @param filename The name of the file to be written out
	 * @param list The list to be written into the file
	 */
	public static void writeFile(String filename, ArrayList<Integer> list)
	{
		Writer writer = null;
		try
		{
			writer = new FileWriter(filename, false);
		}
		catch (IOException ex)
		{
			System.out.println(" Cannot create/open " + filename );
			System.exit(1);
		}
		PrintWriter output = new PrintWriter(writer);
		for(int i = 0; i < list.size(); i++)
			output.print((char)list.get(i).intValue());
		output.close();
	}

	/**
	* Initialize the rotors
	* @param s1 Initial position of rotor 1
	* @param s2 Initial position of rotor 2
	* @param s3 Initial position of the backplate
	* @return true if the initialization was successful, false otherwise
	*/
	public static boolean initializeRotors(int s1, int s2, int s3)
	{
		// returns false if any of the position inputs for the rotors are out of bonds - before 32 or after 126
		if (s1 < 32 || s2 < 32 || s3 < 32 || s1 > 126 || s2 > 126 || s3 > 126)
		{
			return false;
		}

		// clearing all the global array lists
		rotor1.clear();
		rotor2.clear();
		backplate.clear();

		//loops through the first 95 elements in the global arrays and initializes them according to inputted start position
		for (int x = 0; x <= 94; x++)
		{
			//after the ascii value 126 the wheel will go back to 32
			//so when the rotor values pass 126, they are set to 32
			if (s1 == 127)
			{
				s1 = 32;
			}
			if (s2 == 127)
			{
				s2 = 32;
			}
			if (s3 == 127)
			{
				s3 = 32;
			}

			//appending the variable to the global arrays
			rotor1.add(s1);
			rotor2.add(s2);
			backplate.add(s3);

			//increments the s1, s2, and s3 values by one
			s1++;
			s2++;
			s3++;
		}

		//initialization successful
		return true;
	}

	/**
	* Moves a rotor clockwise one position
	* @param rotor The rotor to be rotated
	*/
	public static void advanceRotor(ArrayList<Integer> rotor)
	{
		// removes the last element of the ArrayList and inserts it so the first position
		rotor.add(0, rotor.remove(rotor.size() - 1));
	}

	/**
	* Encrypt the message
	* @param in The message to be encrypted.
	* Each item in the list is a character in ASCII format.
	* @param out The encrypted message.
	* Each item in the list is a character in ASCII format.
	*/
	public static void encryptMessage(ArrayList<Integer> in, ArrayList<Integer> out)
	{

		for (int traverseArr = 0; traverseArr <= in.size() - 1; traverseArr++)
		{
			//System.out.println("String Index: " + traverseArr);

			//locate the traverseArr element in in array on rotor 1
			int step1 = rotor1.indexOf(in.get(traverseArr));
			//System.out.println("Step 1: " + step1);

			// gets the chracter on the backplate of the same position
			int step2 = backplate.get(step1);
			//System.out.println("Step 2: " + step2);

			//locate the position of backplate backplate character on rotor 2
			int step3 = rotor2.indexOf(step2);
			//System.out.println("Step 3: " + step3);

			//lastly locate the character on the backplate of that second position
			int step4 = backplate.get(step3);
			//System.out.println("Step 4: " + step4);

			//appends the value of step3 variable to the out Array List
			out.add(step4);

			//after every element, the rotor1 is rotated once
			advanceRotor(rotor1);

			//once the rotor1 completes a full circle aka 95 characters, rotor2 is rotated once
			if (traverseArr > 0 && (traverseArr + 1) % 95 == 0)
			{
				advanceRotor(rotor2);
			}
		}
	}

	/**
	* Decrypt the message
	* I used the steps as the encrypt function but in reverse
	* @param in The message to be decrypted.
	* Each item in the list is a character in ASCII format.
	* @param out The decrypted message.
	* Each item in the list is a character in ASCII format.
	*/
	public static void decryptMessage(ArrayList<Integer> in, ArrayList<Integer> out)
	{
		for (int traverseArr = 0; traverseArr <= in.size() - 1; traverseArr++)
		{
			//locate the index of the traverseArr element in the backplate
			int step1 = backplate.indexOf(in.get(traverseArr));

			//get the character on rotor2 in the same position (step 1)
			int step2 = rotor2.get(step1);

			//locate the index of the step2 element in the backplate
			int step3 = backplate.indexOf(step2);

			//get the character on rotor1 in the same position(step 3)
			int step4 = rotor1.get(step3);

			//appends the value of step3 variable to the out Array List
			out.add(step4);

			//after every element, the rotor1 is rotated once
			advanceRotor(rotor1);

			//once the rotor1 completes a full circle aka 95 characters, rotor2 is rotated once
			if (traverseArr > 0 && (traverseArr + 1) % 95 == 0)
			{
				advanceRotor(rotor2);
			}
		}
	}

}
