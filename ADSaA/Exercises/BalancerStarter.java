
import java.util.Stack;

public class BalancerStarter {

   public String Balance(String expression){
      Stack<String> returnStack = new Stack<>();

      String[] expressionSplit = expression.split("");

      for (int i = 0; i<expressionSplit.length; i++){
         if (expressionSplit[i].equals("{") || expressionSplit[i].equals("[") || expressionSplit[i].equals("(")){
            returnStack.add(expressionSplit[i]);
         }
         if (expressionSplit[i].equals("}") || expressionSplit[i].equals("]") || expressionSplit[i].equals(")")){
            if (returnStack.isEmpty()){
               return expression + "is not Balanced";
            }
            returnStack.pop();
         }
         
      }
      if (!returnStack.isEmpty()){
         return expression + " is not Balanced";
      }
      return expression + " is balanced";

   }
   
   public static void main(String[] args) {
      BalancerStarter starter = new BalancerStarter();
      String expression1 = "-{ [ b * b - (4 * a * c) ] / (2 * a) }";
      String expression2 = "-[ { [ b * b - (4 * a * c) ] / (2 * a) }";
      String expression3 = "-{ [ b * b - (4 * a * c) ] / (2 * a) } ]";
      String expression4 = "-{ [ b * b - { (4 * a * c) ] / (2 * a) }";


      System.out.println(starter.Balance(expression1));
      System.out.println(starter.Balance(expression2));
      System.out.println(starter.Balance(expression3));
      System.out.println(starter.Balance(expression4));
   } 
}