package CodeSoft;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
	public static void main(String[] args) {
		
		Scanner x = new Scanner(System.in);
		
		Random rand = new Random();
		
		String start = "";
		
		double rounds = 0;
		double wins = 0;
		
		System.out.println("WELCOME TO NUMBER GAME WORLD");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("you can take only 5 attempts to guess the number ");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		do {
			rounds++;
			System.out.println("\n--- Round " + rounds + " ---");
			int hidden_value = rand.nextInt(100)+1;
			System.out.println("Guess the number between 1 and 100 !");
			int min = 1;
			int max = 100;

			for(int i=5;i>0;i--) {
				
				System.out.print("Enter your guess: ");
				int guess_value = x.nextInt();
				
				if(guess_value == hidden_value) {
					System.out.println("yeah !! you found it 😎😎");
					wins++;
					break;
				}
				else if(i==1) {
					System.out.println("sorry you lost 😔😔");
				}
				else if(guess_value > hidden_value) {
					max = guess_value;
					System.out.println("too high !! please guess between "+min +" and "+max);
				}
				else {
					min = guess_value;
					System.out.println("too low  !! please guess between "+min +" and "+max);
	
				}
			}
			System.out.println("Do you want to play again ? (yes/no)");
			start = x.next();
			
			System.out.println("-------------------------------------------------");
			
		}while(start.toLowerCase().equals("yes"));
		
		double score = (wins/rounds)*100;
		System.out.println("\nGame Over! You played " + (int)rounds + " round(s) and wins " + (int)wins + "round(s)");
		System.out.println("Your score is: "+ (int)score);
		
	}
}
