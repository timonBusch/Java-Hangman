package GameMenu;

import difficulty.EasyWordGenerator;
import gameStatus.Game;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import word.GuessedLetter;
import javafx.scene.canvas.GraphicsContext;


/**
 * GameMenu.GUI_Main Class to create the main Window
 * @author timon.buschendorf@fh-bielefeld.de
 */

public class GUI_Main extends Application {

    private GridPane gridStartScene;
    private VBox vBoxGame;
    private BorderPane borderGame;
    private double setPartHeight;
    private double setPartWidth;
    private Scene startScene;
    private Scene gameScene;
    private GraphicsContext gc;
    private Canvas canvas;




    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage window_main = primaryStage;

        DifficultyWindow difficultyWindow = new DifficultyWindow();
        GuessedLetter guessedLetter = new GuessedLetter();
        Game newGame = new Game();
        Menu menu = new Menu();



        //Label to show the guessed letters in the underscores
        Label lbUnderscores = new Label("");
        GridPane.setConstraints(lbUnderscores,0,6);

        // Declare window Titel
        window_main.setTitle("Hangman");


        /*--------- START WINDOW CONTROL ELEMENTS ----------*/

        //Label Titel
        Label lbStartTitel = new Label("Hangman");
        GridPane.setConstraints(lbStartTitel,0,0,2,1);

        //Button Start Game
        Button bntStartGame  = new Button("Start Game");
        bntStartGame.setPadding(new Insets(50,50,50,50));
        GridPane.setConstraints(bntStartGame,0,1);
        bntStartGame.setOnAction(e -> {
            if (difficultyWindow.getDifficultyWord() == null) {
                difficultyWindow.newWord = new EasyWordGenerator();


            }
            window_main.setScene(gameScene);
            newGame.setNewWord(difficultyWindow.getDifficultyWord());
            newGame.runGame();
            lbUnderscores.setText(newGame.getNewWord().getUnderscores());
        });


        // Button to set WordGenerator
        Button bntSetDifficulty = new Button("Difficulty");
        bntSetDifficulty.setPadding(new Insets(50,64,50,50));
        GridPane.setConstraints(bntSetDifficulty,0,2);
        bntSetDifficulty.setOnAction(e -> {
            difficultyWindow.difficultyDisplay("Hangman - Difficulty");

        });

        /*--------- GAME WINDOW CONTROL ELEMENTS ----------*/

        //Canvas
        canvas = new Canvas(600,450);
        gc = canvas.getGraphicsContext2D();
        setPartHeight = (this.canvas.getHeight()/2);
        setPartWidth = (this.canvas.getWidth()/2);


        //Label for Textfield guessWordInput
        Label lbChooseWordToGuess = new Label("Guess the complete word");
        GridPane.setHalignment(lbChooseWordToGuess, HPos.CENTER);
        GridPane.setValignment(lbChooseWordToGuess, VPos.BOTTOM);
        
        //Label to show the guessed letters
        Label lbWordToGuess = new Label("");
        lbWordToGuess.setText("");

        // Textfield to put a word that should be guessed
        TextField guessWordInput = new TextField("");
        guessWordInput.setPromptText("'Maus'");
        guessWordInput.setMaxWidth(200);
        guessWordInput.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                menu.setChoosenWord(guessWordInput.getText());
                guessWordInput.setText("");
                newGame.doOneRoundWithWord();
                lbUnderscores.setText(newGame.getNewWord().getUnderscores());
                switch (newGame.getGameStatus().getProgress()) {
                case 1:
                    //Ground
                    gc.strokeArc(setPartWidth - 100, setPartHeight + 75, 300, 50, 30, 150, ArcType.OPEN);
                    break;
                case 2:
                    //Gallow stake
                    gc.strokeLine(setPartWidth - 70, setPartHeight + 81, setPartWidth - 70, 70);
                    break;
                case 3:
                    //Horizontal bar
                    gc.strokeLine(setPartWidth - 70, 70, setPartWidth + 20, 70);
                    break;
                case 4:
                    //Vertical bar
                    gc.strokeLine(setPartWidth + 20, 70, setPartWidth + 20, 112);
                    break;
                case 5:
                    //Support gallow stake and horizontal bar
                    gc.strokeLine(setPartWidth - 35, 70, setPartWidth - 70, 120);
                    break;
                case 6:
                    //Head
                    gc.strokeOval(setPartWidth, 116, 40, 40);
                    break;
                case 7:
                    //Body
                    gc.strokeLine(setPartWidth + 20, setPartHeight, setPartWidth + 20, 160);
                    break;
                case 8:
                    //Left arm
                    gc.strokeLine(setPartWidth - 20, setPartHeight - 40, setPartWidth + 20, setPartHeight - 30);
                    break;
                case 9:
                    //Right arm
                    gc.strokeLine(setPartWidth + 60, setPartHeight - 40, setPartWidth + 20, setPartHeight - 30);
                    break;
                case 10:
                    //Left leg
                    gc.strokeLine(setPartWidth - 20, setPartHeight + 40, setPartWidth + 20, setPartHeight);
                    break;
                case 11:
                    //Right leg
                    gc.strokeLine(setPartWidth + 60, setPartHeight + 40, setPartWidth + 20, setPartHeight);
                    break;
            }
                if(newGame.getGameStatus().getProgress() == 11){
                    lbWordToGuess.setText("The answer is: " + newGame.getNewWord().getWordToGuess());
                
            } 
        }
        });

        Label lbChooseLetter = new Label("Guess a letter!");


        //Label to show the guessed letters
        Label lbGuessedLetter = new Label("");
        lbGuessedLetter.setText(guessedLetter.getGuessedLetters());

       


        // Textfield to put the letter you want to guess
        TextField txtGuessedLetterInput = new TextField();
        txtGuessedLetterInput.setPromptText("'A'");
        txtGuessedLetterInput.setMaxWidth(200);
        txtGuessedLetterInput.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){

               try{
                   menu.setGuessedLetter(txtGuessedLetterInput.getText());
                   txtGuessedLetterInput.setText("");
                   newGame.doOneRound();
                   lbGuessedLetter.setText(newGame.getNewWord().getGuessedLetters().getGuessedLetters());
                   lbUnderscores.setText(newGame.getNewWord().getUnderscores());
                   //Hangman will be drawn in dependence of the game progress
                   switch (newGame.getGameStatus().getProgress()) {
                       case 1:
                           //Ground
                           gc.strokeArc(setPartWidth - 100, setPartHeight + 75, 300, 50, 30, 150, ArcType.OPEN);
                           break;
                       case 2:
                           //Gallow stake
                           gc.strokeLine(setPartWidth - 70, setPartHeight + 81, setPartWidth - 70, 70);
                           break;
                       case 3:
                           //Horizontal bar
                           gc.strokeLine(setPartWidth - 70, 70, setPartWidth + 20, 70);
                           break;
                       case 4:
                           //Vertical bar
                           gc.strokeLine(setPartWidth + 20, 70, setPartWidth + 20, 112);
                           break;
                       case 5:
                           //Support gallow stake and horizontal bar
                           gc.strokeLine(setPartWidth - 35, 70, setPartWidth - 70, 120);
                           break;
                       case 6:
                           //Head
                           gc.strokeOval(setPartWidth, 116, 40, 40);
                           break;
                       case 7:
                           //Body
                           gc.strokeLine(setPartWidth + 20, setPartHeight, setPartWidth + 20, 160);
                           break;
                       case 8:
                           //Left arm
                           gc.strokeLine(setPartWidth - 20, setPartHeight - 40, setPartWidth + 20, setPartHeight - 30);
                           break;
                       case 9:
                           //Right arm
                           gc.strokeLine(setPartWidth + 60, setPartHeight - 40, setPartWidth + 20, setPartHeight - 30);
                           break;
                       case 10:
                           //Left leg
                           gc.strokeLine(setPartWidth - 20, setPartHeight + 40, setPartWidth + 20, setPartHeight);
                           break;
                       case 11:
                           //Right leg
                           gc.strokeLine(setPartWidth + 60, setPartHeight + 40, setPartWidth + 20, setPartHeight);
                           break;
                   }

               }catch (StringIndexOutOfBoundsException b){
                   System.out.println("Wrong Input");
               }

                if(newGame.getGameStatus().getProgress() == 11){
                    lbWordToGuess.setText("The answer is: " + newGame.getNewWord().getWordToGuess());
                }
            }
        });

        // Button to go back to the menu
        Button bntBackMenu = new Button("Back to menu");
        bntBackMenu.setOnAction(e -> {
            window_main.setScene(startScene);
            lbGuessedLetter.setText("Guessed Letters:");
            lbWordToGuess.setText("");
            lbUnderscores.setText("");
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        /*--------- LAYOUTS ----------*/

        //VBox-Layout Game Scene
        vBoxGame = new VBox();
        vBoxGame.setSpacing(10);
        vBoxGame.setPadding(new Insets(10,0,50,50));
        vBoxGame.setAlignment(Pos.CENTER);
        vBoxGame.getChildren().addAll(lbChooseWordToGuess,guessWordInput,
                lbChooseLetter,txtGuessedLetterInput,
                bntBackMenu,lbGuessedLetter,lbUnderscores,lbWordToGuess);

        //Grid-Layout Start scene
        gridStartScene = new GridPane();
        gridStartScene.setPadding(new Insets(50));
        gridStartScene.setVgap(15);
        gridStartScene.setHgap(25);

        gridStartScene.setGridLinesVisible(false);
        gridStartScene.getChildren().addAll(lbStartTitel,bntStartGame,bntSetDifficulty);

        //Borderpane
        borderGame = new BorderPane();
        borderGame.setBottom(vBoxGame);
        borderGame.setCenter(this.canvas);


        /*--------- SCENES ----------*/
        //Main scene
        gameScene = new Scene(borderGame, 750, 750);

        //Start Scene
        startScene = new Scene(gridStartScene,350,500);


        window_main.setScene(startScene);
        window_main.show();

    }

}
