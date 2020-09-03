public class Node{
    private int key;
    private int value;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }

    int getKey(){
        return key;
    }

    int getValue(){
        return value;
    }

    void setKey(int _key){
        key = _key;
    }

    void setValue(int val){
        value = val;
    }

}