package gameStatus;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import difficulty.EasyWordGenerator;

/**
 * @author K.M.
 */
public class TestGame {

	/**
	 * tests the method checkGameStatus
	 */
	@Test
	public void testCheckGameStatus() {
		Game test = new Game();
		test.setNewWord(new EasyWordGenerator());
		test.runGame();
		GameStatus test1 = test.getGameStatus();
		test.checkGameStatus(0);
		assertEquals(test1, test.getGameStatus());
		assertEquals(1, test.getGameStatus().getProgress());
		test.checkGameStatus(-1);
		assertEquals(test1, test.getGameStatus());
		assertEquals(1, test.getGameStatus().getProgress());
		for (int i = 0; i < 10; i++) {
			((GameRunning) test.getGameStatus()).increaseProgress();
		}
		test.checkGameStatus(0);
		assertFalse(test1.equals(test.getGameStatus()));
	}

}
