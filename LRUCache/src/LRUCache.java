import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache{
    private ArrayList<Node> m_cache = new ArrayList<Node>();
    private HashMap<Integer,Node> m_hashMap = new HashMap<Integer,Node>();
    private int cacheSize;
    LRUCache(int size){
        this.cacheSize = size;
    }

    int get(int key){
        if(m_hashMap.get(key) == null){
            if(m_cache.size() == cacheSize){
                Node lastNode = m_cache.get(cacheSize-1);
                //Remove entry from the hashMap
                m_hashMap.remove(lastNode.getKey());
                //Remove the item from the end of the list
                m_cache.remove(cacheSize-1);
            }
            Node n = new Node(key,0);
            m_cache.add(0,n);
            m_hashMap.put(key,n);
            return n.getValue();
        }
        else{
            //Bring the node to the front of the cache.
            Node oldNode = m_hashMap.get(key);
            int index = m_cache.indexOf(oldNode);
            int value = oldNode.getValue();
            //Remove it from the current index
            m_hashMap.remove(key);
            m_cache.remove(index);
            //Add it to the front of the key
            Node newNode = new Node(key,value);
            m_cache.add(0,newNode);
            m_hashMap.put(key,newNode);
            return value;
        }
    }

    int accessCache(int key){
        return get(key);
    }

    int updateCache(int key,int value){
        accessCache(key);
        m_cache.get(0).setValue(value);
        return 0;
    }

    void displayCache(){
        for(Node n : m_cache){
            System.out.print("{" + n.getKey() + "," + n.getValue() + "}");
        }
        System.out.print("\n");
    }

}