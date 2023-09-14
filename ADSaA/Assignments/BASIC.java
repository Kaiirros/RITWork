package Assignments;

import java.util.LinkedList;
import java.util.ListIterator;

public class BASIC {
    public LinkedList<Integer> program;

    public BASIC(LinkedList<Integer> program){
        this.program = program;

    }
    //ListIterator<Integer> programIterator = program.Listiterator();

    public void listAll(){
        for (int i = 0; i < program.size(); i++){
            System.out.println(program.get(i));
        }
    }

    public void listRange(int first, int last){
        for (int i = 0; i < program.size(); i++){
            if (program.get(i) >= first && program.get(i) <= last){
                System.out.println(program.get(i));
            }
        }
    }

    public void insert(int lineNumber){
        if (program.contains(lineNumber)){
            System.err.println("ERROR: Existing code at position");
        } else {
            for (int i = 0; i < program.size(); i++){
                if (program.get(i) > lineNumber){
                    program.add(i, lineNumber);
                    break;
                }
            }
        }
    }

    public void renumber(){
        for (int i = 0; i < program.size(); i++){

        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> program = new LinkedList<>();
        program.add(10);
        program.add(20);
        program.add(30);
        program.add(40);
        program.add(50);
        program.add(60);
        program.add(70);
        program.add(80);
        program.add(90);
        program.add(100);

        BASIC basic = new BASIC(program);
        basic.insert(17);
        basic.insert(34);
        basic.insert(88);
        basic.listAll();

    }
}
