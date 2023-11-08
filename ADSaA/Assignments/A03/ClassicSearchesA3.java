import java.util.Arrays;
import java.util.*;

public class ClassicSearchesA3 {
   //counts how many elements were looked at before found
   static int ops = 0;
   
   static int linearSearchOrdered(int[] arr, int key) {
      int n = arr.length;
      ops = 0;
      
      for(int i = 0; i < n; i++) {
         ops++;
         if(arr[i] == key)
            return i;
         else if(arr[i] > key) {
            return -1;
         }
      }
            
      return -1;
   }

   static int binarySearch(int arr[], int key) {
      int start = 0;
      int end = arr.length - 1;
      ops = 0;
      
      while(start <= end) {
         ops++;
         int mid = (start + end) / 2;
         if(arr[mid] == key)
            return mid;
         else if(arr[mid] < key)
            start = mid + 1;
         else
            end = mid - 1;
      }
      
      return -1;
   }

   static int interpolationSearch(int[] arr, int key) {
      int low = 0;
      int high = arr.length - 1;
      ops = 0;
      
      while(low <= high && key >= arr[low] && key <= arr[high]) {
         ops++;
         int index = low + (((key - arr[low]) * (high - low)) / 
                     (arr[high] - arr[low]));
         
         if(key == arr[index])
            return index;
         
         if(key < arr[index])
            high = index - 1;
         else
            low = index + 1;
      }

      return -1;
   }

   static int[] generateArray(){
      int[] array = new int[1000];
      Random random = new Random();
      random.nextInt(10000);
      for(int i = 0; i < array.length; i++){
         array[i] = random.nextInt(10000);
      }
      return array;

   }

   static int[] generateArrayPrime(int[] array){
      int[] arrayPrime = new int[1000];
      HashSet<Integer> hashSet = new HashSet<>();

      for (int i = 0; i < array.length; i++){
         hashSet.add(array[i]);
      }
      Random random = new Random();


      for (int i = 0; i < arrayPrime.length; i++){
         int rand = random.nextInt(10000);

         if (!hashSet.contains(rand)){
            arrayPrime[i] = rand;
         } else {
            arrayPrime[i] = rand+2;
         }
      }

      return arrayPrime;
   }

   static void searchResult(String type, int key, int index) {
      if(index != -1)
         System.out.println(type + ": Found " + key + " at index " + index + 
                            " in " + ops + " operations");
      else
         System.out.println(type + ": Did not find " + key + " in " + ops + 
                            " operations");
   }
   
   static void printArray(int arr[]) { 
      int n = arr.length; 
      
      for(int i = 0; i < n; i++) 
         System.out.print(arr[i] + " "); 
      
      System.out.println(); 
   }

   public static void main(String[] args) {
      double foundIndex = 0;
      double notFoundIndex = 0;
      double foundIndex2 = 0;
      double notFoundIndex2 = 0;
      for (int j = 0; j < 100; j++){ // Generating the 100 data sets

         int[] array = generateArray();
         Arrays.sort(array);

         int[] arrayPrime = generateArrayPrime(array);         
         Arrays.sort(arrayPrime);

         foundIndex = 0;
         notFoundIndex = 0;


         for (int i = 0; i < 1000; i++){ // Searches for each element in the data sets

            /*
             * Remove "//" to select search to run
             */

            //linearSearchOrdered(array, array[i]);
            //binarySearch(array, array[i]);
            interpolationSearch(array, array[i]);
            foundIndex += ClassicSearchesA3.ops;
         }
         foundIndex2 += foundIndex;
         


         for (int i = 0; i < 1000; i++){ // Searches for each element NOT in the data sets

            /*
             * Remove "//" to select search to run
             */

            //linearSearchOrdered(arrayPrime, array[i]);
            //binarySearch(arrayPrime, array[i]);
            interpolationSearch(arrayPrime, array[i]);
            notFoundIndex += ClassicSearchesA3.ops;
         }
         notFoundIndex2 += notFoundIndex;


      }
      foundIndex = (foundIndex2/1000)/100;
      notFoundIndex = (notFoundIndex2/1000)/100;
      
   
      System.out.println("\n\nFound Average: " + foundIndex);
      System.out.println("Not Found Average: " + notFoundIndex + "\n\n");

   
   }
}