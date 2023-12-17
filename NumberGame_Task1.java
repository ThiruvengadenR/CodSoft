package codSoftInternship;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.*;

public class NumberGame_Task1 {
	
	private static int totalMistakesMade;
	private static final int maximumMistakeAllowed =4;
	private static long start;
	private static long end;

	public static void main(String[] args) {
		NumberGame_Task1 obj = new NumberGame_Task1();
		obj.instruction();
		obj.set_Starting_Number_for_Range();
		obj.set_Ending_Number_for_Range();
		obj.swapping();
		long randomNumber = (long) (start +(Math.random()*Math.abs(start-end)));
		//System.out.println(randomNumber);
		long userGuess = obj.getinput(start , end);
		obj.checkTheNumber(userGuess , randomNumber ,start ,end);
	}

	private void swapping() {
		if(start<end)
		{
			return ;
		}
		else {
			long temp=start;
			start=end;
			end=temp;
		}
	}

	private long set_Ending_Number_for_Range() {
		System.out.println("Ending Range: The highest number in the range you can guess ");	
		try
		{
			Scanner sc = new Scanner(System.in);
			end  = sc.nextLong();
		}
		catch(InputMismatchException e)
		{
			totalMistakesMade++;
			if(totalMistakesMade>maximumMistakeAllowed)
			{
				termination();
			}
			else
			{
				System.out.println("Only number are allowed ");
				set_Ending_Number_for_Range();
			}
		}
		return end ;
	}

	private long set_Starting_Number_for_Range() {
		System.out.println("Starting Range: The lowest number in the range you can guess from ");
		try
		{
			Scanner sc = new Scanner(System.in);
			 start = sc.nextLong();
		}
		catch(InputMismatchException e)
		{
			totalMistakesMade++;
			if(totalMistakesMade>maximumMistakeAllowed)
			{
				termination();
			}
			else
			{
				System.out.println("Only number are allowed ");
				set_Starting_Number_for_Range();
			}
		}
		return start;
	}

	private void instruction() {
		System.out.println("  ^^^Instructions^^^\n  ");
		System.out.println("## Setup: The game begins by setting a target number, which is a randomly generated number within a predefined range.\n"
				+ "## Range Input: The player is asked to provide a range of numbers within which the target number lies. For example, they might specify a range between 1 and 100.\n"
				+ "## Guessing: The player starts making guesses for the target number within the specified range.\n"
				+ "## Feedback: After each guess, the game provides feedback to the player. If the guess is too high, the player is told that their guess is too high. If the guess is too low, they're informed that their guess is too low.\n"
				+ "## Refinement: Based on the feedback, the player refines their guesses to narrow down the possible range for the target number.\n"
				+ "## Winning: The game continues until the player correctly guesses the target number. Once they guess it right, they're informed that they've won along with the number of guesses they took.\n"
				+ "## Restart: The player can choose to restart the game and try to guess a new target number.");
		System.out.println();
	}

	private void checkTheNumber(long userGuess , long randomNumber , long start ,long end){
		long userGuessNum = userGuess;
		for(int i=1;i<=50;i++)
		{
			if(userGuessNum==randomNumber)
			{
				System.out.println(""
						+ "### Congratulations you are successfully find the random number ###");
				System.out.println(" ***you take " + i+ " attempt to find the random  number *** ");
				System.out.println();
				break;
			}
			else if(userGuessNum>randomNumber)
			{
				System.out.println(userGuessNum +" is Greater than the random number ");
				System.out.println();
				userGuessNum = getinput(start,end);
	
			}
			else if(userGuessNum<randomNumber)
			{
				System.out.println(userGuessNum +" is Smaller than the random number ");
				System.out.println();
				userGuessNum = getinput(start,end);
			}
			else if (i==50)
			{
				System.out.println("Maxium chances are over Try Again ");
				termination();
			}
		}
	}
	
	 private long getinput(long start , long end) {
		System.out.println("Enter the number between " + start +" to "+end );
		long userGuess= -1;
		try {
			 Scanner sc = new Scanner(System.in);
			 userGuess = sc.nextLong();
			 if(userGuess >end || userGuess<start)
			 {
				 throw new ArithmeticException("Please enter the number with in the range");
			 }
		}
		catch(InputMismatchException e)
		{
			totalMistakesMade++;
			if(totalMistakesMade>maximumMistakeAllowed)
			{
				termination();
			}
			else
			{
				System.out.println("Please enter valid number ");
				getinput(start,end);
			}
		}
		catch(ArithmeticException e)
		{
			totalMistakesMade++;
			if(totalMistakesMade>maximumMistakeAllowed)
			{
				termination();
			}
			else
			{
				System.out.println(e);
				getinput(start,end);
			}
		}
		return (userGuess>end)? getinput(start,end):userGuess;
	}
	 private void termination()
	 {
		 System.out.println("Try Again max limit over :( :(");
		 System.out.println("Thank you for Playing the game Please restart the game ");
		 System.exit(0);
	 }
}

