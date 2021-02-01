import java.io.*;
import java.util.Scanner;

public class Hangman {
	
	private int wins, losses;
	private String currentWord;
	private int guesses;
	Scanner response = new Scanner(System.in);
	
	Hangman(){
		
	}
	
	public void loadWL() {
		try {
			File WL = new File("Win-Loss.txt");
			Scanner Read = new Scanner(WL);
			
			wins = Read.nextInt();
			losses = Read.nextInt();
			
			Read.close();
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}// try and catch are done
	}
	
	public void writeWL() throws IOException{
		try {
			File WL = new File("Win-Loss.txt");
			Writer w = new FileWriter(WL);
			
			w.write(wins + "\n");
			w.write(losses + "\n");
			
			w.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}// try and catch are done
	}
	
	public void playGame(){
		
			
			guesses = 5;
			
				Dictionary Webster = new Dictionary();
				Webster.readFile("Words.txt");
				currentWord = Webster.chooseWord();
			
			
			
		System.out.println("Would you like to play Y/N");
		String playerResponse = response.nextLine();
		char [] baseWord = currentWord.toCharArray();
		char [] correctAnswer = currentWord.toCharArray();
		char playerInput;
		
		for(int i = 0; i < currentWord.length(); i++) {
			baseWord[i]  = '_';
		}
		if(playerResponse.equals("N")) {
			System.out.println("Thank you for playing, goodbye!");
		}
		
		if(playerResponse.equals("Y")) {
			System.out.println("You have " + guesses + " incorrect guesses left");
			System.out.println(baseWord);
			
			while(String.valueOf(baseWord).equals(currentWord) == false && guesses > 0){
				System.out.println("What is your guess?");
				playerResponse = response.nextLine();
				playerInput = playerResponse.charAt(0);
				boolean correct = false;
				
				for(int i = 0; i < currentWord.length(); i++) {
					if(correctAnswer[i] == playerInput) {
						baseWord[i] = playerInput;
						System.out.println(baseWord);
						correct = true;
					}//if
					
				}//for
				
				if(correct) {
					System.out.println("You have " + guesses + " left.");
				}
				
				else {
					guesses-- ;
					System.out.println("You have " + guesses + " left.");
				}
			}//while
			
			if(String.valueOf(baseWord).equals(currentWord) == false || guesses == 0) {
				System.out.println("You lost :( The word was " + currentWord);
				losses++;
				System.out.println("You have " + wins + " wins and " + losses + " losses. Press any key.");
				String pressKey = response.nextLine();
				if(pressKey != "maya rocks") {
					playGame();
				}
				else {
					System.out.println("How on earth did you guess that?");
				}
			}
			else {
				System.out.println("Yay!! You won!");
				wins++;
				System.out.println("You have " + wins + " wins and " + losses + " losses. Press any key.");
				String pressKey = response.nextLine();
				if(pressKey != "maya rocks") {
					playGame();
				}
				else {
					System.out.println("How on earth did you guess that?");
				}
			}
		}//if
		
		else {
			System.out.println("You had " + wins + " wins and " + losses + " losses.");
			
		}
	}
	
}

