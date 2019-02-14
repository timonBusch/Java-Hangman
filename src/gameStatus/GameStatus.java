package gameStatus;

/**
 * 
 * @author K.M.
 */
public abstract class GameStatus {

	protected static int progress;
	protected int maxProgress = 11;

	/**
	 * @param progress
	 *            The current progress from GameRunning
	 * @return Returns true if the current progress is 10, otherwise false
	 */
	protected boolean checkProgress(int progress) {
		boolean returnValue = false;
		if (progress == maxProgress) {
			returnValue = true;
		}
		return returnValue;
	}

	/**
	 *
	 * @return Returns the progress
	 */
	public int getProgress() {
		return progress;
	}
}
