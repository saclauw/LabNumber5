
/*Steven Clauw LAB NUMBER 5
 * 
 * Create an application that simulates dice rolling
 * 
 *  - Ask the user to enter the number of sides for a pair of dice
 *  - Prompt the user to roll the dice
 *  - "Roll" two n-sided dice, display the results of each, and then ask the user if he/she
 *  	   wants to roll the dice again.
 *  
 *  BUILD SPECS
 *  	--Use static methods to implement the method(s) that generate the random numbers
 *  --Experiment with Random number generators-start with the random()method of the Math class,
 *    but also explore Java's random class.
 *    
 *  HINTS
 *  --Chapter 6, and section 2.14(Random Numbers)
 *  
 *  XTRA XTRA
 *  --Use the DiceRollerApp class to display special messages for craps, snake eyes, and box cars.
 * 
 *  -- box cars is two 6, snake eyes, two 1, craps is 7 and 11
 * CONSOLE PREVIEW
 * Welcome to the Grand Circus Casino!
 * 
 * How many sides should each die have? {User input, for example 6}
 * 
 * Roll 1:
 * 2
 * 5
 * 
 * Roll again? (y/n):...
 * 
 */
import java.util.Scanner;
import java.util.Random;

public class LabNumber5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int sidesDice = 0;
		String cont = "y";
		boolean validNum; 

		System.out.println("Welcome to the Grand Circus Casino!");
		System.out.println("");

		while (cont.equalsIgnoreCase("y")) {
			// BEGIN INPUT FOR CASINO GAME

			do { // do / while loop used to validate -- Sorry Maurice (I will incorporate the shorter while loop validation next time
				System.out.print("How many sides should each die have? ");
				if (scan.hasNextInt()) { // if input is an integer it goes on to next step of validation
					sidesDice = scan.nextInt();
					validNum = true;
				}
				if ((sidesDice >= 1) && (sidesDice <= 100)) {
					validNum = true;
				} else { // if input is not an integer or integer in the parameter this prints
					System.out.print("Not a valid entry. ");
					validNum = false;
					scan.nextLine();
				}
			} while (!(validNum));

			//Display how many sided dice will be rolled for user gratification
			System.out.println("");
			System.out.println("The die are going to be " + sidesDice + "-sided.");
			System.out.println("");

			//Result 1 utilizes a user defined method, the users input for sidesDice populates the amount of random numbers generated
			//Result 2 utilizes Java's random class
			int result1 = dice1(sidesDice);
			int result2 = (int) rand.nextInt(sidesDice) + 1;
			System.out.println("Roll 1:"); // I was trying to find a way to increment roll number with each continuation of the loop, but was competing with the continue while loop....
			System.out.println(result1);
			System.out.println(result2);

			//Hard code of special messages for craps, snake eyes, and box cars
			if ((result1 + result2 == 7) || (result1 + result2 == 11)) {
				System.out.println("");
				System.out.println("Craps!");
			} else if ((result1 == 1) && (result2 == result1)) {
				System.out.println("");
				System.out.println("Look out for them snake eyes!");
			} else if ((result1 == 6) && (result2 == result1)) {
				System.out.println("");
				System.out.println("Check out 'dem box cars!");
				;
			}
			// END OF INPUT FOR CASINO GAME
			System.out.println("");
			System.out.print("Roll again? (y/n): ");
			cont = scan.next();
			System.out.println("");
			if (!cont.equalsIgnoreCase("y")) {
				System.out.println("Goodbye!");
				
				scan.close();
			}
		}
	}

	/*
	 * GENERATES RANDOM NUMBER OF SIDES TO DICE
	 */
	public static int dice1(int num) {
		int dice1 = (int) (Math.random() * num) + 1; // generate a random number
		return dice1;
	}
}
