import java.util.LinkedList;



class Edge {
   int weight;
   int endNode;
   char endNodeName;


   Edge(char endNodeName, int weight, int endNode){
      this.weight = weight;
      this.endNode = endNode;
      this.endNodeName = endNodeName;
   }

   public int getEdgeWeight(){
      return weight;
   }
   public int getEndNode(){
      return endNode;
   }

   public String toString(){
      return endNodeName + ": " + weight;
   }
}

class WeightedGraph {
   private int N; // number of nodes in the graph
   private char[] names; // names of each node
   private LinkedList<Edge> adj[]; // adjacency list for each node
   
   WeightedGraph(int numNodes, char[] nodeNames) {
      N = numNodes;
      adj = new LinkedList[N]; // create an adjacency list for each node
      names = new char[N];
      
      for(int i = 0; i < N; i++) {
         adj[i] = new LinkedList<>(); // create empty list of edges
         names[i] = nodeNames[i]; // name the current node
      }
   }
   
   public void addEdge(int startNode, int endNode, int weight) {
      Edge edge = new Edge(names[endNode], weight, endNode);

      adj[startNode].add(edge);
   }
   
   public int getNumNodes() {
      return N;
   }
   
   public char[] getNodeNames() {
      return names;
   }
   
   public LinkedList<Edge>[] getAdjList() {
      return adj;
   }
   
   public String toString() {
      String output = new String();
      
      for (int i = 0; i<adj.length; i++){
         output += names[i] + ": " + adj[i] + "\n";

      }
      
      return output;
   }
}



public class Dijkstra { 
   
   static int[] dijkstra(WeightedGraph graph, int source) { 
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
   
      // find shortest path to all nodes 
      for(int count = 0; count < N; count++) { 
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
         System.out.println("Visiting node " + graph.getNodeNames()[minIndex]);  

         
      
         for(int i = 0; i < adj[minIndex].size(); i++) {
            // Update distances only if node has not been visited, 
            // there is an edge from minimum distance node to node i,
            // and the total length of path from source to node i
            // via minimum distance node is smaller than current value
            // stored in distances 
            int neighbor = adj[minIndex].get(i).getEndNode();
            
            if(!visited[i] && distances[minIndex] + distances[neighbor] < distances[i]){
               
            distances[i] = distances[minIndex] + distances[neighbor];

            }

         } 
      }  
      
      return distances;
   } 
   
   static void printDistances(int distances[], char[] nodes) { 
      int N = distances.length;
      System.out.println("Node  Distance"); 
      
      for(int i = 0; i < N; i++) 
         System.out.println(nodes[i] + "\t\t" + distances[i]); 
   }
  
   public static void main(String[] args) 
   { 
      char[] nodeNames = {'A', 'B', 'C', 'D', 'E', 'F', 'G'}; // Nodes 0, 1, 2, 3, 4
      WeightedGraph graph = new WeightedGraph(nodeNames.length, nodeNames);

      graph.addEdge(6, 2, 5); // G->C
      graph.addEdge(2, 6, 5); // G<-C

      graph.addEdge(2, 1, 1); // C->B
      graph.addEdge(1, 2, 1); // C<-B

      graph.addEdge(2, 3, 4); // C->D
      graph.addEdge(3, 2, 4); // C<-D

      graph.addEdge(1, 0, 1); // B->A
      graph.addEdge(0, 1, 1); // B<-A

      graph.addEdge(3, 0, 1); // D->A
      graph.addEdge(0, 3, 1); // D<-A

      graph.addEdge(3, 5, 6); // D->F
      graph.addEdge(5, 3, 6); // D<-F

      graph.addEdge(3, 4, 4); // D->E
      graph.addEdge(4, 3, 4); // D<-E

      graph.addEdge(5, 4, 3); // F->E
      graph.addEdge(4, 5, 3); // F<-E
      graph.addEdge(4, 3, 4); // D<-E

      System.out.println(graph.toString());

      int distances[] = dijkstra(graph, 6);
      
      printDistances(distances, nodeNames);
   } 
}