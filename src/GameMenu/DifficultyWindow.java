package GameMenu;

import difficulty.WordGenerator;
import difficulty.EasyWordGenerator;
import difficulty.HardWordGenerator;
import difficulty.MediumWordGenerator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * GameMenu.DifficultyWindow Class to create a new window to set the difficulty
 * @author timon.buschendorf@fh-bielefeld.de
 */

public class DifficultyWindow {


    protected WordGenerator newWord;

    /**
     * Creating the main window with all UI controls and functionality
     * @param title Gets the titel from GameMenu.GUI_Main
     */

    protected void difficultyDisplay(String title){
        Stage diffWindow = new Stage();

        diffWindow.setTitle(title);
        diffWindow.setMaxWidth(250);
        Label lbChooseDiff = new Label("Choose difficulty");

        // Group of RadioButtons so just one can be checked
        ToggleGroup rbGroup = new ToggleGroup();

        //Radio button
        RadioButton rbDiff1 = new RadioButton("1");
        RadioButton rbDiff2 = new RadioButton("2");
        RadioButton rbDiff3 = new RadioButton("3");
        rbGroup.getToggles().addAll(rbDiff1,rbDiff2,rbDiff3);
        rbDiff1.setSelected(true);

        //Button to set the difficulty

        Button bntsetDiff = new Button("Set difficulty");
        bntsetDiff.setOnAction(e -> {
            chooseWord(rbDiff1,rbDiff2,rbDiff3);
            diffWindow.close();
        });

        // WordGenerator.WordGenerator window layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(lbChooseDiff,rbDiff1,rbDiff2,rbDiff3,bntsetDiff);
        layout.setAlignment(Pos.CENTER);

        // Scene for difficulty window
        Scene diffScene = new Scene(layout,400,200);
        diffWindow.setScene(diffScene);
        diffWindow.showAndWait();

    }

    /**
     * Choose word in dependence of the choosen difficulty
     *
     */
    private void chooseWord(RadioButton rbDiff1, RadioButton rbDiff2, RadioButton rbDiff3){

        if(rbDiff1.isSelected()){
            newWord = new EasyWordGenerator();
        }else if(rbDiff2.isSelected()){
            newWord = new MediumWordGenerator();
        }else if(rbDiff3.isSelected()){
            newWord = new HardWordGenerator();
        }
    }

    protected WordGenerator getDifficultyWord(){
        return  newWord;
    }



}
