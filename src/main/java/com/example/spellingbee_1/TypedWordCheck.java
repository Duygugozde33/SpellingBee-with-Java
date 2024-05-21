package com.example.spellingbee_1;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class TypedWordCheck {
    public Boolean IsValid(Label typedword, ArrayList<String> pangramlet){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (typedword.getText().length()==0){
            alert.setTitle("Warning");
            alert.setHeaderText("Empty!");
            alert.setContentText("The written word can not be empty");
            alert.showAndWait();
            return false;
        }
        if (typedword.getText().length()<=3){
            alert.setTitle("Warning");
            alert.setHeaderText("Too Short!");
            alert.setContentText("The written word needs to be at least 4 letters long");
            alert.showAndWait();
            return false;
        }
        if (!typedword.getText().contains(pangramlet.get(3))){
            alert.setTitle("Warning");
            alert.setHeaderText("Middle Letter!");
            alert.setContentText("The written word does not contain the middle letter");
            alert.showAndWait();
            return false;
        }
        else{
            return true;
        }
    }
}
