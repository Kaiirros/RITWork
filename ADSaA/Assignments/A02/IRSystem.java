package Assignments.A02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class TermEntry{
    String term;
    int count;

    public String getTerm(){
        return term;
    }
    public int getCount(){
        return count;
    }
}

public class IRSystem {
    
    public String[] parse(String filename) throws IOException{
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String quoteStrings ="";
        while ((quoteStrings+=bufferedReader.readLine()) != null){
            continue;
        }
        System.out.println(quoteStrings.toString());
        bufferedReader.close();
        return null;
    }

    public static void main(String[] args) throws IOException {
        IRSystem irSystem = new IRSystem();
        irSystem.parse("ADSaA\\Assignments\\A02\\quotes.txt");
    }
}
