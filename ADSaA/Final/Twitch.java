package Final;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import Final.Dijkstra;

public class Twitch {

    static HashMap<Integer, Integer> hashMap;
    static WeightedGraph graph;

    public void readFile(String filename) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(filename));
        int users = Integer.parseInt(br.readLine());

        graph = new WeightedGraph(users);

        String readString = "";
        while((readString=br.readLine())!=null){
            String[] userConnection = readString.split(" ");
            graph.addEdge(Integer.parseInt(userConnection[0]), Integer.parseInt(userConnection[1]), 1);

        }

        br.close();

        System.out.println(graph.toString());
    

    }

    public static void main(String[] args) throws IOException {
        Twitch twitch = new Twitch();

        twitch.readFile("ADSaA\\Final\\friendships2.txt");
    }

}