import java.util.LinkedList;
import java.util.ListIterator;

public class test {

   public static void listTest(){
      LinkedList<String> list = new LinkedList<String>();
      
      list.add("Head");
      list.add("Element 10");
      list.add("Element 20");
      list.add("Element 30");
      list.add("Element 40");

      System.out.println("ListTest list elements");
      for (int i=0; i < list.size(); i++){
         System.out.println("Node value = " + list.get(i));
      }

      list.remove();
      list.set(0, "Head");

      System.out.println("List after delete and update");
      for (int i = 0; i<list.size(); i++){
         System.out.println("Node value = " + list.get(i));
      }

   }

   public static void IteratorTest(){
      LinkedList<String> list = new LinkedList<String>();
      list.add("Head");
      list.add("Element 10");
      list.add("Element 20");
      list.add("Element 30");
      list.add("Element 40");

      ListIterator<String> list_Iter = list.listIterator();

      System.out.println("ListIteratorTest list elements");
      while (list_Iter.hasNext()){
         System.out.println("Node value = " + list_Iter.next());
      }

      list_Iter = list.listIterator(2);
      list_Iter.add("Element 11");

      list_Iter = list.listIterator();

      System.out.println("List after insert");
      while (list_Iter.hasNext()){
         System.out.println("Node value = " + list_Iter.next());
      }
   }



   public static void main(String[] args) {
/*     int[] numbers = new int[10];
    System.out.println(numbers.length);

    int elementMemory = numbers.length * Integer.SIZE;
    System.out.println("Array elements use " + elementMemory + " bits");
    int elementMemoryBytes = elementMemory / Byte.SIZE;
    System.out.println("Array elements use " + elementMemoryBytes + " bytes");

    String str = new String("This is a string");
    int charMemory = ( str.length() * Character.SIZE ) /Byte.SIZE;
    System.out.println("Character array elements use " + charMemory + " bytes"); */

    IteratorTest();
   }
}


