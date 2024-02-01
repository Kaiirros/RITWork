package A01;

import java.util.LinkedList;
import java.util.ListIterator;

public class BASIC {
    public LinkedList<Integer> program;
    ListIterator<Integer> programIterator;

    public BASIC(LinkedList<Integer> program){
        this.program = program;

    }
    

    public void listAll(){
        programIterator = program.listIterator();
        while (programIterator.hasNext()){
            System.out.println(programIterator.next());
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
        int num = 10;
        int size = program.size();
        program.clear();
        for (int i = 0; i < size; i++){
            program.add(i, num);
            num += 10;
        }
    }

    public void modify(int lineNumber, int newLineNumber){
        if (program.contains(newLineNumber)){
            System.err.println("ERROR: Line already occupied");
            return;
        }
        if (!program.contains(lineNumber)){
            System.err.println("ERROR: Line does not exist");
            return;
        }
        program.remove(program.indexOf(lineNumber));
        this.insert(newLineNumber);

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
        System.out.println("1>---");
        basic.listAll();
        System.out.println("2>---");
        basic.listRange(40, 80);
        System.out.println("Checkpoint ^");
        basic.insert(17);
        basic.insert(34);
        basic.insert(88);
        System.out.println("6>---");
        basic.listAll();
        basic.renumber();
        System.out.println("8>---");
        basic.listAll();
        basic.insert(80);
        basic.modify(9, 14);
        basic.modify(10, 110);
        basic.modify(10, 111);
        System.out.println("13>---");
        basic.listAll();
        basic.renumber();
        System.out.println("15>---");
        basic.listAll();


    }
}
