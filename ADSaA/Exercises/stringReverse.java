
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stringReverse {
    
    public String reverse(String in){
        String[] stringSplit = in.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        String returnString = "";

        for (int i = 0; i < stringSplit.length; i++){
            stack.push(stringSplit[i]);
        }

        for (int y = stack.size(); y > 0; y--){
            queue.add(stack.pop());
            
        }

        for (int x = queue.size(); x >0; x--){
            returnString+= queue.remove();
        }

        return returnString;
    }

    public static void main(String[] args) {
        stringReverse stringReverse = new stringReverse();
        System.out.println(stringReverse.reverse("goodbye"));
    }
}
