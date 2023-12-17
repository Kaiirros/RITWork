package Final;
import java.util.LinkedList;


class Edge {
   int weight;
   int endNode;
   int startNode;
   char endNodeName;
   char startNodeName;


   Edge(int weight, int startNode, int endNode){
      this.weight = weight;
      this.endNode = endNode;
      this.startNode = startNode;
   }

   public int getEdgeWeight(){
      return weight;
   }
   public int getEndNode(){
      return endNode;
   }
   public char getEndNodeName(){
      return endNodeName;
   }
   public char getStartNodeName(){
      return startNodeName;
   }

   public int getStartNode(){
      return startNode;
   }

   public String toString(){
      return Integer.toString(endNode);
   }
}

class WeightedGraph {
   private int N; // number of nodes in the graph
   private LinkedList<Edge> adj[]; // adjacency list for each node
   
   WeightedGraph(int numNodes) {
      N = numNodes;
      adj = new LinkedList[N]; // create an adjacency list for each node
      
      for(int i = 0; i < N; i++) {
         adj[i] = new LinkedList<>(); // create empty list of edges
      }
   }
   
   public void addEdge(int startNode, int endNode, int weight) {
      Edge edge = new Edge(weight, startNode, endNode);

      adj[startNode].add(edge);
   }
   
   public int getNumNodes() {
      return N;
   }
   
   public LinkedList<Edge>[] getAdjList() {
      return adj;
   }
   
   public String toString() {
      String output = new String();
      
      for (int i = 0; i<adj.length; i++){
         output += i + ": " + adj[i] + "\n";

      }
      
      return output;
   }
}



public class Dijkstra { 
   
   static int[][] dijkstra(WeightedGraph graph, int source) { 
      int N = graph.getNumNodes();
      LinkedList<Edge> adj[] = graph.getAdjList();
      
      // denotes shortest distance from source node to all other nodes
      int distances[] = new int[N]; 
      int previousNodes[] = new int[N];

      // indicates if the node has been visited or not (defaults to false)
      boolean visited[] = new boolean[N]; 
   
      // initialize shortest distance to all nodes as "infinity" 
      for (int i = 0; i < N; i++){
         distances[i] = Integer.MAX_VALUE; 
      }
      distances[source] = 0; // distance from source node to itself is 0
      previousNodes[source] = -1;
      // find shortest path to all nodes 
      for(int count = 0; count < N-1; count++) { 
         // choose the minimum distance node from the set of nodes 
         // not yet visited 
         int min = Integer.MAX_VALUE;
         int minIndex = -1; 
      
         for(int i = 0; i < N; i++) {
            if(!visited[i] && distances[i] <= min) { 
               min = distances[i]; 
               minIndex = i; 
            } 
         }

         // mark the minimum distance node as visited
         visited[minIndex] = true; 

         System.out.println("Visiting node " + minIndex);  
         int name = minIndex;

         for(int i = 0; i < adj[minIndex].size(); i++) {
            // Update distances only if node has not been visited, 
            // there is an edge from minimum distance node to node i,
            // and the total length of path from source to node i
            // via minimum distance node is smaller than current value
            // stored in distances 
            int neighbor = adj[minIndex].get(i).getEndNode();

            if(!visited[neighbor] && distances[minIndex] + adj[minIndex].get(i).getEdgeWeight() < distances[neighbor]){

            previousNodes[neighbor] = name;

            distances[neighbor] = distances[minIndex] + adj[minIndex].get(i).getEdgeWeight();

            }

         } 
      }

      int[][] twoDArray = {distances, previousNodes};

      return twoDArray;
   } 
   
   static void printDistances(int distances[][], char[] nodes, int source) { 
      int N = nodes.length;
      System.out.println("Node \t   Distance \t Previous Node"); 
      for(int i = 0; i < N; i++){

         System.out.println(nodes[i] + "\t\t" + distances[0][i] + "\t\t" + distances[1][i]);

      }

      for(int i = 0; i < distances[1].length; i++){

         if( i != source){
            System.out.print("\n" + "Shortest path from " + nodes[source] + " to " + nodes[i] + "\t");
            printPaths(i, distances[1], nodes, source);            
         }
      }

   }

   static void printPaths(int current, int distances[], char[] nodes, int source){
      if (current == -1){
         return;
      }
      
      printPaths(distances[current], distances, nodes, source);

      System.out.print(nodes[current] + " ");
   }
  
}