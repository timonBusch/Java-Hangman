/**
 * @author S.R.
 */
package word;

import java.util.HashSet;

public class GuessedLetter {
	private HashSet<String> letterList = new HashSet<String>();
	private String newestChar;
	protected String returnLetter;
	private String values;

	/**
	 * 
	 * @return Returns already guessed chars
	 */
	public String getGuessedLetters() {
		values = "Guessed letters: ";
		for (String letter : letterList) {
			values += (" " + letter);
		}
		return values;
	}

	/**
	 * @return Returns the hashSet letterList
	 */
	public HashSet<String> getLetterListHashSet(){
		return letterList;
	}

	/**
	 * creates an Object of Input and compares the input with earlier inputs
	 * 
	 * @return Returns the user input of a single letter
	 */
	public String addNewGuessedLetter() {
		Input userInput = new Input();
		newestChar = userInput.getInput();
		returnLetter = "";
		if (userInput.inputStartsWithLetter) {
			return null;
		} else {
			if (letterList.contains(newestChar)) {
				return null;
			} else {
				letterList.add(String.valueOf(userInput.inputLetter));
				returnLetter = newestChar;
				return returnLetter;
			}
		}
	}
	
	/**
	 * @return Returns the user input of a complete word
	 */
	public String tryToSolve() {
		Input input = new Input();
		return input.getInputChoosenWord();
	}
}
