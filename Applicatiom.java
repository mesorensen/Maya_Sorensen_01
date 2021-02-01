import java.io.*;

public class Applicatiom {
	public static void main(String[] args) throws IOException{
		Hangman Game = new Hangman();
		
		Game.loadWL();
		
		Game.playGame();
		
		
		Game.writeWL();
	}
}
