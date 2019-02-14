/**
 *@author S.R.
 */
package word;

import GameMenu.Menu;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class TestWord {
	/**
	 * tests the functions of the Input class
	 */
	@Test
	void testInput() {
		Input testInput = new Input();
		Menu testMenu = new Menu();
		testMenu.setGuessedLetter("b");
		assertEquals((String)"B",testInput.getInput());
		assertEquals(false,testInput.inputStartsWithLetter);
		testMenu.setGuessedLetter("1");
		assertEquals((String)"1",testInput.getInput());
		assertEquals(true,testInput.inputStartsWithLetter);
		testMenu.setChoosenWord("TestWord");
		assertEquals("TESTWORD",testInput.getInputChoosenWord());
		
	}
}