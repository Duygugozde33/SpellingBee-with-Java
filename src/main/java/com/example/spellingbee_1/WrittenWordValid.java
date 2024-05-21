package com.example.spellingbee_1;

import java.util.ArrayList;

public class WrittenWordValid {
    char[] alphabet = {'A','B','C','Ç','D','E','F','G','Ğ','H','I','İ','J','K','L','M','N','O','Ö','P','R','S','Ş','T','U','Ü','V','Y','Z'};
    public Boolean isTextValid(String writtenText){
        Boolean validlet=false;
       char[] inputtext = writtenText.toCharArray();
       for (int i=0;i<inputtext.length;i++){
           for (int j=0;j<alphabet.length;j++){
               if(inputtext[i]==alphabet[j]){
                   validlet=true;
               }
           }
       }
       if(validlet==true){
           ArrayList<Character> writtenList = new ArrayList<>();
           for (int i = 0; i < writtenText.length(); i++) {
               char ch = writtenText.charAt(i);
               if (writtenList.size() == 0) {
                   writtenList.add(ch);
               }
               if (!writtenList.contains(ch)) {
                   writtenList.add(ch);
               }
           }
           if (writtenList.size()==7){
               return true;
           }
       }
       return false;
    }
}
