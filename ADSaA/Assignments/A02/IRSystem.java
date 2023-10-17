package Assignments.A02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class TermEntry{
    String term;
    int count;

    public TermEntry(String term, int count){
        this.term = term;
        this.count = count;
    }

    public String getTerm(){
        return term;
    }
    public int getCount(){
        return count;
    }
}

class Node {
   Node left;
   Node right;
   TermEntry data;

   
   public Node(TermEntry value) {
      data = value;
   }
}

class BinarySearchTree {
   Node root; // root node of the entire tree
   int layer = 0;
   
   public BinarySearchTree(LinkedList<TermEntry> keys) {
     // sort keys in ascending order
      keys.sort(null);
      int start = 0;
      int end = keys.size() - 1;
      int mid = (start + end) / 2;
      root = new Node(keys.get(mid));
      
      // left side of array passed to left subtree
      insert(root, keys, start, mid - 1);
      // right side of array passed to right subtree
      insert(root, keys, mid + 1, end);
   }
   
   public void insert(Node node, LinkedList<TermEntry> keys, int start, int end) {
      if(start <= end) {
         int mid = (start + end) / 2;
         if(keys.get(mid) < node.data) { // left subtree
            node.left = new Node(keys[mid]);
            insert(node.left, keys, start, mid - 1);
            insert(node.left, keys, mid + 1, end);
         }
         else { // right subtree
            node.right = new Node(keys[mid]);
            insert(node.right, keys, start, mid - 1);
            insert(node.right, keys, mid + 1, end);
         }
      }
   }
   
   public void inorderTraversal(Node node, boolean reverse) {
      // print the contents of the tree in increasing order
      if(node != null) {
         if (!reverse){
            inorderTraversal(node.left, reverse);
            System.out.println("Visited " + node.data); // print node's key value
            inorderTraversal(node.right, reverse);            
         } else {
            inorderTraversal(node.right, reverse);
            System.out.println("Visited " + node.data); // print node's key value
            inorderTraversal(node.left, reverse);  
         }

      }
   }

   public void preorderTraversal(Node node){
      if(node != null) {
         System.out.println("Visited " + node.data); // print node's key value         
         preorderTraversal(node.left);
         preorderTraversal(node.right);
      }
   }

   public void postorderTraversal(Node node){
      if(node != null) {
         postorderTraversal(node.left);
         postorderTraversal(node.right);
         System.out.println("Visited " + node.data); // print node's key value 
      }
   }

   public String getLayer(){
      return String.valueOf(layer);
   }
   
   public Node search(Node node, int key) {
      if(node == null)
         // hitting an empty node means search has failed
         return null;
      if(node.data == key)
         // found a match, return the Node's data
         return node;
      else if(node.data > key){
         // need to search the left subtree since key is less than node value
         layer++;
         return search(node.left, key);
      }else{
         // key value is larger than current node, search right subtree
         layer++;
         return search(node.right, key); 
      }
   }
}



public class IRSystem {
    HashMap<String, Integer> countMap = new HashMap<>();
    
    private String[] parse(String filename) throws IOException{
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

    private void countTerms(String[] terms){

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

    private TermEntry singleTermQuery(Node node, String term){
        return null;
    }

    public static void main(String[] args) throws IOException {
        IRSystem irSystem = new IRSystem();
        String[] terms = irSystem.parse("ADSaA\\Assignments\\A02\\quotes.txt");

        irSystem.countTerms(terms);

        LinkedList<TermEntry> list = new LinkedList<>();

        for (String element : irSystem.countMap.keySet()){
            TermEntry termEntry = new TermEntry(element, irSystem.countMap.get(element));
            list.add(termEntry);
        }

        BinarySearchTree bst = new BinarySearchTree(list);
    }
}
