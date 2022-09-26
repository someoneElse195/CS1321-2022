/**
 *
 */
import java.util.*;
import java.io.*;

/**
 * @author Ashton West
 *
 */
public class Project_4 {



	public static void main(String[] args) throws FileNotFoundException {

		String[] dictionary = readFile("dictionary.txt");
		boolean gameActive = false;
		boolean gameStart = true;
		char guessLetter;
		String hashedWord;
		String randomWord;
		Scanner scnr = new Scanner(System.in);
		int wrongCounter;
		String continuePlaying;

		//Game initialization and calling random word method + hash method
		while(gameStart) {

			randomWord = chooseRandomWord(dictionary);
			hashedWord = createPound(randomWord);
			wrongCounter = 0;
			
			gameActive = true;
			//Starting the actual interactive part of the game
			while(gameActive) {

				//Checking if game is won/lost
				if(wrongCounter == 7) {
					gameActive = false;
					break;
				}
				else if(hashedWord.equals(randomWord)) {
					System.out.println("Correct! you have won this game. The word is: " + randomWord);
					gameActive = false;
					break;
				}

				//Calling guess method and checking if old has is equal to the new one
				System.out.println("Guess any letter in the word");
				System.out.println(hashedWord);
				guessLetter = scnr.next().charAt(0);			
				String newHash = guessWord(guessLetter, randomWord, hashedWord);
				if(!(newHash.equals(hashedWord))) {
					hashedWord = newHash;
					continue;
				}
				else {
					wrongCounter++;
				}
				
				hangmanImage(wrongCounter, randomWord);			
			
			}

			//Checking if player would like to continue
			System.out.println("Do you still want to play?");
			continuePlaying = scnr.next();
			
			if(continuePlaying.equals("yes")) {
				gameActive = true;
			}
			else {
				break;
			}

		}
		scnr.close();

	}

	//Method for checking if the guessed character is present in the word and replacing all instances of it
	public static String guessWord(char guess, String word, String dashes) {

		char[] splitWord = word.toCharArray();
		char[] splitDashes = dashes.toCharArray();
		for(int i = 0; i < splitDashes.length; i++) {
			if(guess == splitWord[i]) {
				splitDashes[i] = guess;
			}
		}
	
		String result = new String(splitDashes);

		return result;
	}

	//Method for reading the file and creating a dictionary array of words to choose from
	public static String[] readFile(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		Scanner scnr = new Scanner(file);
		int numLines = 0;
		while(scnr.hasNextLine()) {
			scnr.nextLine();
			numLines += 1;
		}
		scnr.close();
		scnr = new Scanner(file);
		String[] dictionary = new String[numLines];
		for(int i = 0; i < numLines; i++) {
			dictionary[i] = scnr.next();
		}
		scnr.close();
		return(dictionary);

	}

	//Converting all the characters in the word into a #
	public static String createPound(String word) {
		
		int wordLength = word.length();
		char[] splitWord = word.toCharArray();
		
		String hashes = "#";
		char hash = hashes.charAt(0);
		
		for(int i = 0; i < wordLength; i++) {
			splitWord[i] = hash;
		}
		String hashedWord = new String(splitWord);
		return hashedWord;

	}

	//Choosing a random word from the dictionary
	public static String chooseRandomWord(String[] words) {

		int randomNumber = new Random().nextInt(words.length);
		return words[randomNumber];

	}

	//Decides which hangman image to print based on the number of incorrect guesses
	public static void hangmanImage(int count, String word) {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
	
}
