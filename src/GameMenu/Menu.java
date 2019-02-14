package GameMenu;

/**
 * GameMenu.Menu Class for saving important variables from the GUI
 * @author timon.buschendorf@fh-bielefeld.de
 */

public class Menu  {


    private static String choosenWord;
    private static String guessedLetter;


    /**
     * Get the choose word from GameMenu.GUI_Main and save it to choosenWord
     * @param choosenWord
     */
    public void setChoosenWord(String choosenWord){
        this.choosenWord = choosenWord;
    }

    /**
     * Get the gueesed letters from GameMenu.GUI_Main and save it to guessedLetter
     * @param guessedLetter
     */
    public void setGuessedLetter(String guessedLetter){
             this.guessedLetter = guessedLetter;

    }

    /**
     *
     * @return the that was guessed in the text field
     */
    public String getGuessedLetter(){
        return guessedLetter;
    }

    /**
     *
     * @return the word that was choosen in the text field
     */
    public String getChoosenWord() {
        return choosenWord;
    }



}

