package com.example.spellingbee_1;


import java.util.ArrayList;
import java.util.Random;

public class QuickPlaySetup {
    char[] pangramLetters;
    ArrayList<String> allPangramlist = new ArrayList<String>(); // Pangram kelimeler
    ArrayList<String> pangramList = new ArrayList<String>();// Birbirinden farklı harflerin pangram listesi
    public char[] findPangramLet(ArrayList<String> wordList) {
        Random random = new Random();
        for (String word : wordList) {
            if (word.length() >= 7) {
                ArrayList<Character> list = new ArrayList<>();
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (list.size() == 0) {
                        list.add(ch);
                    }
                    if (!list.contains(ch)) {
                        list.add(ch);
                    }
                }
                StringBuffer sbr = new StringBuffer();
                if (list.size() == 7) {
                    for (char ch : list) {
                        sbr.append(ch);
                    }
                    allPangramlist.add(word);
                    pangramList.add(sbr.toString().toUpperCase());
                    int randindex = random.nextInt(pangramList.size());
                    String pangofgame = pangramList.get(randindex);
                    pangramLetters = pangofgame.toCharArray();
                }
            }

        }
        return pangramLetters;
    }
}

