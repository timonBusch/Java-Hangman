
package gameStatus;

import difficulty.WordGenerator;
import word.Word;

/**
 * 
 * @author K.M.
 *
 */
public class Game {

	private GameStatus gameStatus;
	private Word newWord;

	/**
	 * @return Returns game status
	 */
	public GameStatus getGameStatus() {
		return this.gameStatus;
	}

	/**
	 * Creates new Word
	 * 
	 * @param difficulty
	 *            Object of class difficulty
	 */
	public void setNewWord(WordGenerator difficulty) {
		this.newWord = new Word(difficulty);
	}

	/**
	 * @return Returns an Object of class Word
	 */
	public Word getNewWord() {
		return this.newWord;
	}

	/**
	 * Runs the game (to play a game this method must run one time)
	 */
	public void runGame() {
		this.gameStatus = new GameRunning();
		((GameRunning) gameStatus).setProgress(0);
	}

	/**
	 * Does one Round of the Game with one letter guessed
	 */
	public void doOneRound() {
		if (gameStatus instanceof GameRunning) {
			int helpVar = newWord.getCorrectLetters();
			newWord.replaceUnderscore();
			checkGameStatus(helpVar);

		} else if (gameStatus instanceof GameWon) {
			System.out.println("Bereits gewonnen");
		} else if (gameStatus instanceof GameLost) {
			System.out.println("Breits verloren");
		}

	}

	/**
	 * Checks the current GameStatus after the users input. Method gets used in
	 * doOneRound()
	 */
	void checkGameStatus(int helpVar) {
		if (newWord.getLettersArray().equals(newWord.getUnderscoresArray()) == true) {
			this.gameStatus = new GameWon();
			System.out.println("Gewonnen");

		} else if (helpVar == newWord.getCorrectLetters()) {

			((GameRunning) gameStatus).increaseProgress();
			if (gameStatus.checkProgress(gameStatus.getProgress()) == true) {

				this.gameStatus = new GameLost();
				System.out.println("Verloren");
			}
		} else if (helpVar < newWord.getCorrectLetters()) {
			System.out.println("Richtiger Buchstabe");
		}
	}

	/**
	 * Does one Round of the Game with a guessed word
	 */

	public void doOneRoundWithWord() {
		if (gameStatus instanceof GameRunning) {
			if (newWord.checkCompleteWord() == true) {
				gameStatus = new GameWon();
				System.out.println("Gewonnen");
			} else {
				((GameRunning) gameStatus).increaseProgress();
				if (gameStatus.checkProgress(gameStatus.getProgress()) == true) {
					gameStatus = new GameLost();
					System.out.println("Verloren");
				}
			}
		} else if (gameStatus instanceof GameWon) {
			System.out.println("Bereits gewonnen");
		} else if (gameStatus instanceof GameLost) {
			System.out.println("Bereits Verloren");
		}
	}

}
