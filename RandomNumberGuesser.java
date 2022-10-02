/*
 * Class: CMSC203 
 * Instructor:
 * Description: This assignment allows the user to enter a number to guess
 * a random integer. This code provides an input validation to make sure the guess is 
 * in the range. The user has up to 7 tries. Once the 7 tries is reached, the game is over.  
 * Due: 09/29/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Iban Vasquez
*/

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		int exactNum; 	// exact number to guess
		int guess = 0;
		int highLim = 100;
		int lowLim = 1;
		String answer = "no";
		boolean val = false;
		Scanner input = new Scanner(System.in); 
		
		System.out.println("This application generates a random "
				+ "integer between 1 and 100"
				+ "\nand asks the user to guess repeadetly until they guess correctly.\n ");
		do
		{
			exactNum = RNG.rand();
			System.out.println("Enter your first guess: ");
			while(guess != exactNum && RNG.getCount() < 7)
			{

				do
				{
					guess = input.nextInt();
					val = RNG.inputValidation(guess, lowLim, highLim);
				}while( val == false && RNG.getCount() < 7);
				if(guess < exactNum && RNG.getCount() < 7)
				{
					lowLim = guess + 1;
					System.out.println("Number of guesses: " + RNG.getCount());
					System.out.println("Enter your next guess between " + lowLim + " and " + highLim);
				}
				else if(guess > exactNum && RNG.getCount() < 7)
				{
					highLim = guess - 1;
					System.out.println("Number of guesses: " + RNG.getCount());
					System.out.println("Enter your next guess between " + lowLim + " and " + highLim);
				}
				else if(guess == exactNum)
				{
					System.out.println("Congratulations, you guessed correctly");
				}
				
			}
			if(RNG.getCount() >= 7 && guess != exactNum)
			{
				System.out.println("You have exceeded the maximum number of guesses, 7. Try again.");
			}
			else 
			{
				System.out.println("Try again? (Yes or No)");
				answer = input.next();
			}
			RNG.resetCount();
			guess = 0;
			highLim = 100;
			lowLim = 1;
	
		}while(answer.equalsIgnoreCase("Yes"));
		System.out.println("DONE");
		input.close();
	}

}
