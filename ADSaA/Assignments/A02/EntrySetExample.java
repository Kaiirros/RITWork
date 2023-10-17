package A02;
import java.util.HashMap;
import java.util.Map.Entry;

class EntrySetExample {
   public static void main(String[] args) {
   
      HashMap<String, Integer> terms = new HashMap<>();
      terms.put("seattle", 1);
      terms.put("mariners", 1);
      terms.put("all", 4);
      System.out.println(terms);
   
      // entrySet() returns a set of all entries so we can
      // access all of the HashMap elements
      for(Entry<String, Integer> entry : terms.entrySet()) {
         System.out.println(entry.getKey() + ": " + entry.getValue());
      }
   }
}
