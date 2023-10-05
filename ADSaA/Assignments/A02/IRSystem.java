package Assignments.A02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
    HashMap<String, Integer> countMap = new HashMap<>();
    
    public String[] parse(String filename) throws IOException{
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String readerString ="";
        String holdString = "";
        while((readerString=bufferedReader.readLine())!=null){
            holdString+= readerString + " ";
        }
        holdString = holdString.toLowerCase();
        String[] returnTokens = holdString.split(" ");
        bufferedReader.close();
        return returnTokens;
    }

    public void countTerms(String[] terms){

        for (String element : terms){
            if (countMap.containsKey(element)){
                countMap.replace(element, countMap.get(element).intValue()+1);
            }
            if (!(countMap.containsKey(element))){
                countMap.put(element, 1);
            }
        }
        System.out.println(countMap.toString());

    }

    public static void main(String[] args) throws IOException {
        IRSystem irSystem = new IRSystem();
        String[] terms = irSystem.parse("ADSaA\\Assignments\\A02\\quotes.txt");

        irSystem.countTerms(terms);
    }
}
