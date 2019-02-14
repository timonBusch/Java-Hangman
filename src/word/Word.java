/**
 *@author S.R.
 */
package word;

import java.util.ArrayList;
import difficulty.WordGenerator;

public class Word {
	private int correctLetters = 0;
	private String wordToGuess;
	private ArrayList<String> letters = new ArrayList<String>();
	private ArrayList<String> underscore = new ArrayList<String>();
	private GuessedLetter guessedLetters = new GuessedLetter();

	/**
	 * Constructor of the class
	 * 
	 * @param difficulty Object of class WordGenerator
	 */
	public Word(WordGenerator difficulty) {
		wordToGuess = difficulty.getRandomWord().toUpperCase();
		writeWordInLetters(wordToGuess);
		replaceLetters();
	}

	/**
			* @return Returns the arrayList letters
     */
	public ArrayList<String> getLettersArray(){
		return letters;
	}
    /**
			* @return Returns the arrayList underscores
     */
	public ArrayList<String> getUnderscoresArray(){
		return underscore;
	}

	/**
	 *
	 * @return the guessed letters
	 */
	public GuessedLetter getGuessedLetters() {
		return guessedLetters;
	}

	/**
	 * writes every char of wordToGuess as String into the ArrayList letters
	 * 
	 * @param wordToGuess Needs the String wordToGuess
	 */
	public void writeWordInLetters(String wordToGuess) {
		for (int i = 0; i < wordToGuess.length(); i++) {
			letters.add(String.valueOf((wordToGuess.charAt(i))));
		}
	}

	/**
	 * fills ArrayList underscore with underscores
	 */
	public void replaceLetters() {
		for (int i = 0; i < letters.size(); i++) {
			underscore.add("_");
		}
	}

	/**
	 * compares the word in question with the user input and replaces underscores
	 */
	public void replaceUnderscore() {
		guessedLetters.addNewGuessedLetter();
		for (int i = 0; i < letters.size(); i++) {
			if (letters.get(i).equals(guessedLetters.returnLetter)) {
				underscore.set(i, letters.get(i));
				correctLetters++;
			}
		}
	}

	/**
	 *
	 * @return a String with all the underscores for a word
	 */
	public String getUnderscores() {
		String returnValue = " ";
		for (String letter : this.underscore) {
			returnValue += (" " + letter);
		}
		return returnValue;
	}

	/**
	 * 
	 * @return Returns the value correctLetters
	 */
	public int getCorrectLetters() {
		return correctLetters;
	}

	/**
	 *
	 * @return the word that should be guessed
	 */

	public String getWordToGuess(){
		return wordToGuess;
	}

	/**
	 * 
	 * @return Returns boolean true if the input is equal to the correct word, else
	 *         false
	 */
	public boolean checkCompleteWord() {
		String wordToTest = guessedLetters.tryToSolve();
		if (wordToGuess.equals(wordToTest)) {
			for (int i = 0; i < letters.size(); i++) {
				underscore.set(i, letters.get(i));
			}
			return true;
		} else {
			return false;
		}
	}
}
