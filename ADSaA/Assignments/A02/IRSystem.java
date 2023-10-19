package A02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

class TermEntry implements Comparable<TermEntry>{
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

    public String toString(){
      return term + ": " + count;
    }

   @Override
   public int compareTo(TermEntry o) {
      return this.term.compareTo(o.term);
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
   
   public BinarySearchTree(LinkedList<TermEntry> keys) {
     // sort keys in ascending order
      Collections.sort(keys);
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
         if(keys.get(mid).getTerm().compareTo(node.data.getTerm()) > 0) { // left subtree
            node.left = new Node(keys.get(mid));
            insert(node.left, keys, start, mid - 1);
            insert(node.left, keys, mid + 1, end);
         }
         else { // right subtree
            node.right = new Node(keys.get(mid));
            insert(node.right, keys, start, mid - 1);
            insert(node.right, keys, mid + 1, end);
         }
      }
   }
   
   public void inorderTraversal(Node node, boolean reverse) {
      // print the contents of the tree in increasing order
      if(node != null) {
         if (!reverse){
            inorderTraversal(node.right, reverse);
            System.out.println("Visited " + node.data); // print node's key value
            inorderTraversal(node.left, reverse);
         } else {

            inorderTraversal(node.left, reverse);
            System.out.println("Visited " + node.data); // print node's key value
            inorderTraversal(node.right, reverse);   
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

   
   public TermEntry search(Node node, String key) {
      if(node == null)
         // hitting an empty node means search has failed
         return null;
      if(node.data.getTerm().equals(key))
         // found a match, return the Node's data
         return node.data;
      else if(node.data.getTerm().compareTo(key) < 0){
         // need to search the left subtree since key is less than node value
         return search(node.left, key);
      }else{
         // key value is larger than current node, search right subtree
         return search(node.right, key); 
      }
   }
}



public class IRSystem {
    HashMap<String, Integer> countMap = new HashMap<>();
    BinarySearchTree bst;

    public void setBst(BinarySearchTree bst){
      this.bst = bst;
    }
    
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

    }

   private TermEntry singleTermQuery(Node node, String term){
      return bst.search(node, term);
   }

   private boolean andQuery(String term1, String term2){

      if (singleTermQuery(bst.root, term1) != null){
         if (singleTermQuery(bst.root, term2) != null){
            return true;
         }
      }

      return false;
   }

   private boolean orQuery(String term1, String term2){

      if (singleTermQuery(bst.root, term1) != null){
         return true;
      }
      if (singleTermQuery(bst.root, term2) != null){
         return true;
      }
      return false;
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
         //bst.inorderTraversal(bst.root, false);
         irSystem.setBst(bst);

         System.out.println("1 ------------------------");
         bst.inorderTraversal(bst.root, false);

         System.out.println("2 ------------------------");
         TermEntry found = irSystem.singleTermQuery(bst.root, "all");

         if(found != null){
            System.out.println("Found: '" + found.getTerm() + "' with a count of:  " + found.getCount());
         }else{
            System.out.println("'" + found + "' not found");
         }

         System.out.println("3 ------------------------");
         found = irSystem.singleTermQuery(bst.root, "carrying");

         if(found != null){
            System.out.println("Found: '" + found.getTerm() + "' with a count of:  " + found.getCount());
         }else{
            System.out.println("'" + found + "' not found");
         }

         System.out.println("4 ------------------------");
         String term = "robot";
         found = irSystem.singleTermQuery(bst.root, term);

         if(found != null){
            System.out.println("Found: '" + found.getTerm() + "' with a count of:  " + found.getCount());
         }else{
            System.out.println("'" + term + "' not found");
         }

         System.out.println("5 ------------------------");
         System.out.println("Successful?: " + irSystem.andQuery("seattle","mariners"));

         System.out.println("6 ------------------------");
         System.out.println("Successful?: " + irSystem.andQuery("seattle","pilots"));

         System.out.println("7 ------------------------");
         System.out.println("Successful?: " + irSystem.orQuery("four","score"));

         System.out.println("8 ------------------------");
         System.out.println("Successful?: " + irSystem.orQuery("five","score"));

         System.out.println("9 ------------------------");
         System.out.println("Successful?: " + irSystem.orQuery("five","robots"));

    }
}
