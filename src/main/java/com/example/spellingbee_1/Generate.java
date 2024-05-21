package com.example.spellingbee_1;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Generate {
    public void generateAGame(TextField writtenText, Button letterBtn0, Button letterBtn1, Button letterBtn2, Button letterBtn3, Button letterBtn4, Button letterBtn5, Button letterBtn6, ArrayList<String> pangramlet){
        QuickPlaySetup gensetup = new QuickPlaySetup();
        DataBase data = new DataBase();
        char[] testchar = gensetup.findPangramLet(data.readText());
        System.out.println(gensetup.pangramList);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        String zx = writtenText.getText();
        WrittenWordValid inputvalid = new WrittenWordValid();
        if(inputvalid.isTextValid(zx)==false){
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid character!");
            alert.setContentText("The written word does not meet the conditions");
            alert.showAndWait();
        }
        else {
            Boolean Equals=false;
            for(String words:gensetup.pangramList){
                if(words.equals(zx)){
                    Equals=true;
                    char[] panchars=zx.toCharArray();
                    for (int k= 0; k < 7; k++) {
                        String x = Character.toString(panchars[k]);
                        pangramlet.add(x);
                    }

                }

            }
            Letters assignbut = new Letters();
            assignbut.assignButtons(letterBtn0,letterBtn1,letterBtn2,letterBtn3,letterBtn4,letterBtn5,letterBtn6,pangramlet);
            assignbut.shuffle(letterBtn1,letterBtn2,letterBtn3,letterBtn4,letterBtn5,letterBtn6);
            if(Equals==false){
                alert.setTitle("Warning");
                alert.setHeaderText("Pangram Condition!");
                alert.setContentText("The written word is not a pangram");
                alert.showAndWait();
            }
        }
    }
}
