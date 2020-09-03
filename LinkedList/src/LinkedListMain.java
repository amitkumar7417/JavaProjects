import java.util.ArrayList;
public class LinkedListMain {
    public static void main(String [] args){
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(24);
        num.add(12);
        num.add(36);
        num.add(48);
        num.add(72);
        LinkedList l = new LinkedList(num);
        l.display();
    }
}
