package Final;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Twitch {

    static HashMap<Integer, Integer> hashMap;
    static WeightedGraph graph;
    static int users;

    public void readFile(String filename) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(filename));
        users = Integer.parseInt(br.readLine());

        graph = new WeightedGraph(users);

        String readString = "";
        while((readString=br.readLine())!=null){
            String[] userConnection = readString.split(" ");
            graph.addEdge(Integer.parseInt(userConnection[0]), Integer.parseInt(userConnection[1]), 1);
            graph.addEdge(Integer.parseInt(userConnection[1]), Integer.parseInt(userConnection[0]), 1);

        }

        br.close();

        System.out.println(graph.toString());
    

    }

    public static void main(String[] args) throws IOException {
        Twitch twitch = new Twitch();
        DecimalFormat df = new DecimalFormat("#.00");
        float degrees = 0;

        twitch.readFile("ADSaA\\Final\\twitch_friendships.txt");

        int distances[][] = Dijkstra.dijkstra(graph, 0);
 
        for (int i = 0; i < distances[0].length; i++){
            degrees += distances[0][i];
        }

        //degrees = (degrees/Twitch.users);

        System.out.println("Average Twitch User Friend Count = " + df.format(Twitch.graph.friendAverage()/Twitch.users) + " friends");
        System.out.println("Average Twitch User Separation = " + df.format(degrees/Twitch.users) + " degrees");

        HashMap<Integer, Integer> friendCountMap = WeightedGraph.friendCountMap;
        for (Map.Entry element : friendCountMap.entrySet()){
            System.out.println("User: " + element.getValue() + ", Friend Count: " + element.getKey());
        }
    }


}