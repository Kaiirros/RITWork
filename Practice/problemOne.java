package Practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// Letter Combinations of a Phone number
public class problemOne {


public List<String> letterCombinations(String digits) {
      String[] digitArray = digits.split("");
      List<String> returnlist = new LinkedList<String>();

      //Constructs the map of digit:"abc"
      Map<String, String> keyboardMap = Map.of(
        "2", "abc",
        "3", "def",
        "4", "ght",
        "5", "jkl",
        "6","mno",
        "7","pqrs",
        "8","tuv",
        "9","wxyz");

    String tempString = "";

    for (int x = 0; x < digitArray.length; x++){

        for (int i = 0; i < keyboardMap.get(digitArray[x]).length(); i++){

            tempString += keyboardMap.get(digitArray[x]).split("")[i];

            for (int y = digitArray.length; 0 < y; y--){

                tempString += keyboardMap.get(digitArray[y]).split("")[i];
                System.out.println(tempString);

            }


            System.out.println(tempString);
        }
        


        
    }
    System.out.println(returnlist);


      return returnlist;

         
         
    }


    public static void main(String[] args) {
        problemOne problemOne = new problemOne();
        System.out.println(problemOne.letterCombinations("23"));
        
        
    }
}
