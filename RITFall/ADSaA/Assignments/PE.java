import java.util.*;

public class PE {
   static int runs = 1;
   public static void roundRobin(int numTasks, int numRuns) {
      Queue<Integer> q = new LinkedList<Integer>();

      if (numRuns == 0){
         return;
      }
      
      // ******* Do not modify Lines 8 and 9 ********
      for(int i = 1; i <= numTasks; i++)
         q.add(i);
      // ******* Do not modify Lines 8 and 9 ********
      
      // ******* Add your code below this line *******

      for (int i = 1; i <= numTasks; i++){
         System.out.println("Run " + runs + ": " + "Task: " + i);
         q.remove(i);
      }
      runs++;

      roundRobin(numTasks, numRuns-1);
   }
   
   public static void main(String[] args) {
      roundRobin(5, 5);
   }
}
