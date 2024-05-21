package com.example.spellingbee_1;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;

public class Letters {
    public void shuffle(Button ltr1, Button ltr2, Button ltr3, Button ltr4, Button ltr5, Button ltr6) {
        ArrayList<String> letters = new ArrayList<String>();
        letters.add(ltr1.getText());
        letters.add(ltr2.getText());
        letters.add(ltr3.getText());
        letters.add(ltr4.getText());
        letters.add(ltr5.getText());
        letters.add(ltr6.getText());
        Collections.shuffle(letters);
        ltr1.setText(letters.get(0));
        ltr2.setText(letters.get(1));
        ltr3.setText(letters.get(2));
        ltr4.setText(letters.get(3));
        ltr5.setText(letters.get(4));
        ltr6.setText(letters.get(5));
    }

    public void assignButtons(Button ltr0, Button ltr1, Button ltr2, Button ltr3, Button ltr4, Button ltr5, Button ltr6, ArrayList<String> pangramLet) {
        ltr0.setText(pangramLet.get(3));
        ltr1.setText(pangramLet.get(0));
        ltr2.setText(pangramLet.get(1));
        ltr3.setText(pangramLet.get(2));
        ltr4.setText(pangramLet.get(4));
        ltr5.setText(pangramLet.get(5));
        ltr6.setText(pangramLet.get(6));

    }


}
