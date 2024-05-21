package com.example.spellingbee_1;

import java.util.ArrayList;
import java.util.Objects;

public class PossibleAnswers {
    public static ArrayList<String> Selecting(ArrayList<String> pangramLet){
        ArrayList<String> allFind = new ArrayList<>();
        DataBase read = new DataBase();
        String middleLetter = pangramLet.get(3);
        for (String element : Objects.requireNonNull(read.readText())){
            if ((element.length()>3) && (element.contains(middleLetter))){
                allFind.add(element);
            }
        }
        return allFind;
    }
    public static ArrayList<String> possibleWords(ArrayList<String> allFind,ArrayList<String> pangramlet){
        ArrayList<String> confirmedWords = new ArrayList<String>();
        int counter = 0;
        for (String item:allFind){
            for(String letter : pangramlet){
                if(item.contains(letter)){
                    counter++;
                }
            }
            if ((counter>= 4) & (!confirmedWords.contains(item))){
                confirmedWords.add(item);
            }
        }
        return confirmedWords;
    }
}
