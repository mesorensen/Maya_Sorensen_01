import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
	
	private String[] wordList = new String[213];
	private int randomNum;
	

	public void readFile(String fileName) {
		
		try {
			File Book = new File(fileName);
			Scanner Read = new Scanner(Book);
			
			for(int i = 0; i < 213; i++) {
				wordList[i] = Read.nextLine();
			} //close for
			
			Read.close();
		} //
		
		catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}// close catch  
	} // close read file method
	
	
	public String chooseWord() {
		Random randomNumbers = new Random();
		randomNum = randomNumbers.nextInt(213);
		
		return wordList[randomNum];
		}// close chooseWord
	
}



