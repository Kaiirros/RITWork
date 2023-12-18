package Final;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class Twitch {

    static TreeMap<Integer, Integer> hashMap;
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

    }

    public static void main(String[] args) throws IOException {
        Twitch twitch = new Twitch();
        DecimalFormat df = new DecimalFormat("#.00");
        float degrees = 0;
        float degrees2 = 0;

        twitch.readFile("ADSaA\\Final\\twitch_friendships.txt");


        for (int i = 0; i < Twitch.users; i++){
            int distances[][] = Dijkstra.dijkstra(graph, i);

            for (int j = 0; j < Twitch.users; j++){
                degrees2 += distances[0][j];                
            }
            degrees = degrees2/Twitch.users;

        }

        System.out.println("Average Twitch User Separation = " + df.format(degrees/Twitch.users) + " degrees");
        System.out.println("Average Twitch User Friend Count = " + df.format(Twitch.graph.friendAverage()/Twitch.users) + " friends");

        Map<Integer, Integer> friendCountMap = WeightedGraph.friendCountMap.descendingMap();

        int i = 0;
        System.out.println(" \nTop 10 Twitch user friend counts");
        for (Map.Entry<Integer, Integer> entry : friendCountMap.entrySet()) {
            if (i >= 10){
                break;
            }
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("User: " + value + ", Friend Count: " +key);
            i++;
        }
    }

}