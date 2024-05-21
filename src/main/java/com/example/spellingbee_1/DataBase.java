package com.example.spellingbee_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataBase {
    public ArrayList<String> readText() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            BufferedReader file = new BufferedReader(new FileReader("C:\\sozluk_v2.txt"));   //texti okuma
            String s;
            while ((s = file.readLine()) != null) {
                list.add(s);
            }
            file.close();
            for (int i=0;i<list.size();i++){
                String newvalue = list.get(i).toUpperCase();
                list.set(i,newvalue);
            }
            return list;
        }
        catch (Exception ex) {
            return null;
        }

    }
}