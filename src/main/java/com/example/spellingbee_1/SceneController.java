package com.example.spellingbee_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SceneController {
    public Stage stage;
    public Scene scene;
    @FXML
    TextField writtenText;
    @FXML
    Label typedWord;
    @FXML
    Label pointCounter;
    @FXML
    Label answerList;
    @FXML
    Button letterBtn0;
    @FXML
    Button letterBtn1;
    @FXML
    Button letterBtn2;
    @FXML
    Button letterBtn3;
    @FXML
    Button letterBtn4;
    @FXML
    Button letterBtn5;
    @FXML
    Button letterBtn6;
    @FXML
    Button startGameButtonGen;
    ArrayList<String> pangramlet = new ArrayList<String>();

    public void switchToQuickPlay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QuickPlay.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startGameButtonGen(ActionEvent event){
        Generate generategame = new Generate();
        generategame.generateAGame(writtenText,letterBtn0,letterBtn1,letterBtn2,letterBtn3,letterBtn4,letterBtn5,letterBtn6,pangramlet);
    }
    public void startGameButton(ActionEvent event) {
        QuickPlaySetup quickplay = new QuickPlaySetup();
        DataBase data = new DataBase();
        char[] panchars;
        panchars = quickplay.findPangramLet(data.readText());
        for (int i = 0; i < 7; i++) {
            String x = Character.toString(panchars[i]);
            pangramlet.add(x);
        }
        Letters assignbut = new Letters();
        assignbut.assignButtons(letterBtn0,letterBtn1,letterBtn2,letterBtn3,letterBtn4,letterBtn5,letterBtn6,pangramlet);
        assignbut.shuffle(letterBtn1,letterBtn2,letterBtn3,letterBtn4,letterBtn5,letterBtn6);
    }
    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToGenerate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GeneratePlay.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void pushLetterButton(ActionEvent buttonpress) {
        if (buttonpress.getSource() == letterBtn0) {
            typedWord.setText(typedWord.getText() + letterBtn0.getText());
        } else if (buttonpress.getSource() == letterBtn1) {
            typedWord.setText(typedWord.getText() + letterBtn1.getText());
        } else if (buttonpress.getSource() == letterBtn2) {
            typedWord.setText(typedWord.getText() + letterBtn2.getText());
        }
        else if (buttonpress.getSource() == letterBtn3) {
            typedWord.setText(typedWord.getText() + letterBtn3.getText());
        } else if (buttonpress.getSource() == letterBtn4) {
            typedWord.setText(typedWord.getText() + letterBtn4.getText());
        } else if (buttonpress.getSource() == letterBtn5) {
            typedWord.setText(typedWord.getText() + letterBtn5.getText());
        } else if (buttonpress.getSource() == letterBtn6) {
            typedWord.setText(typedWord.getText() + letterBtn6.getText());
        }
    }
    public void pushDeleteButton(ActionEvent event) {
        StringBuffer x = new StringBuffer(typedWord.getText());
        x.deleteCharAt(typedWord.getText().length() - 1);
        String word = x.toString();
        typedWord.setText(word);
        if (typedWord == null) {
            typedWord.setText(typedWord.getText() + " ");
        }
    }
    public void shuffleButton(ActionEvent event) {
        Letters shuffle1 = new Letters();
        shuffle1.shuffle(letterBtn1, letterBtn2, letterBtn3, letterBtn4, letterBtn5, letterBtn6);
    }
    public void enterButton(ActionEvent event) {
        CompareNPoint submit = new CompareNPoint();
        TypedWordCheck typedlabelcheck = new TypedWordCheck();
        Boolean valid = typedlabelcheck.IsValid(typedWord,pangramlet);
        ArrayList<String> confirmedarr = new ArrayList<String>();
        confirmedarr= PossibleAnswers.possibleWords(PossibleAnswers.Selecting(pangramlet),pangramlet);

        if(valid == true){

            submit.submitAnswer(typedWord.getText(),confirmedarr,pointCounter,answerList);

        }
    }
    public void generateButton(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("GeneratedGamePlay.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
