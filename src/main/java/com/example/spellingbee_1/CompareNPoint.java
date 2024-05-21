package com.example.spellingbee_1;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class CompareNPoint {
    int points=0;
    int totalpoint;


    public Boolean isPangram(String tahmin,ArrayList<String> allpangramList) {
        for (String element : allpangramList) {
            if (tahmin == element) {
                return true;
            }
        }
        return false;
    }
    public String submitAnswer(String tahmin, ArrayList<String> confirmedWords,Label pointLabel,Label answerList) {
        ArrayList<String> foundWords  = new ArrayList<String>();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Boolean word_valid=false;
        for (String word : confirmedWords) {

            if (tahmin.equals(word)) {
                word_valid=true;
                answerList.setText(answerList.getText()+"\n"+word);
                totalpoint = totalpoint + calculatePoints(tahmin);
                String p = Integer.toString(totalpoint);
                pointLabel.setText(p);
            }
        }
        if (word_valid==false){
            alert.setTitle("Warning");
            alert.setHeaderText("Can not find the word!");
            alert.setContentText("The written word is not a valid one");
            alert.showAndWait();
        }

        return tahmin;
    }
    public int calculatePoints(String tahmin) {
        QuickPlaySetup pangrams = new QuickPlaySetup();
        if (tahmin.length()>=4) {
            points = tahmin.length()-3;
        }

       /* if (isPangram(tahmin,pangrams.allPangramlist)) {
            points += 7;
        } */
        return points;
    }
}


