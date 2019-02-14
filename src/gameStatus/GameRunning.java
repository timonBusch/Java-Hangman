
package gameStatus;


/**
 * 
 * @author K.M.
 *
 */
public class GameRunning extends GameStatus {

	/**
	 * Sets the new Progress
	 * 
	 * @param progress
	 *            The new Progress
	 */
	protected void setProgress(int progress) {
		GameStatus.progress = progress;
	}

	/**
	 * Increases the progress by 1
	 */
	protected void increaseProgress() {
		GameStatus.progress += 1;
	}

}
