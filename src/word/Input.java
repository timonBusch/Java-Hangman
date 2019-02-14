/**
 * @author S.R.
 */
package word;

import GameMenu.Menu;

public class Input {
	protected String inputLetter;
	private String iLetter;
	protected String input;
	public boolean inputStartsWithLetter = false;

	/**
	 * @return Returns a single capital letter
	 */
	public String getInput() {
		Menu menu = new Menu();
		input = menu.getGuessedLetter();
		iLetter = input.toUpperCase();
		inputLetter = String.valueOf(iLetter.charAt(0));
		inputStartsWithLetter = inputLetter.matches("[^a-zA-Z]");
		return inputLetter;
	}

	/**
	 * @return Returns a word guessed to be the correct answer
	 */
	public String getInputChoosenWord() {
		Menu menu = new Menu();
		String wordToTest = menu.getChoosenWord().toUpperCase();
		return wordToTest;
	}
}
