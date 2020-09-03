import java.util.ArrayList;
class LinkedListNode{
    public int data;
    LinkedListNode next;

    LinkedListNode(int val){
        this.data = val;
        this.next = null;
    }

}


public class LinkedList {
    private LinkedListNode head;
    private LinkedListNode tail;

    public LinkedList(ArrayList<Integer> num){
        this.head = null;
        this.tail = null;
        for(Integer i : num)
            insert(i);
    }

    public void insert(int val){
        LinkedListNode newNode = new LinkedListNode(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void display(){
        if(head == null)
            System.out.println("List is empty");
        LinkedListNode tmp = head;
        while(tmp != null){
            System.out.print(tmp.data + "'\t'");
            tmp = tmp.next;
        }
    }
}
