
class BinaryHeapNode {
    public int capacity;
    public int size;
    public int [] arr = null;
    public int heapType; // 1 denotes maxHeap, 0 denotes minHeap;
    public BinaryHeapNode(int capacity,int heapType){
        this.capacity = capacity;
        this.heapType = heapType;
        arr = new int[capacity];
    }
}

public class BinaryHeap{
    private BinaryHeapNode root = null;
    public BinaryHeap(int capacity,int heap_type){
        root = new BinaryHeapNode(capacity,heap_type);
    }

    public int getParent(int childIndex){
        if (childIndex <= 0 || childIndex >= root.size)
            return -1;
        return (childIndex - 1)/2;
    }
    public int leftChild(int parentIndex){
        int left = 2 * parentIndex + 1;
        if(left > root.size)
            return -1;
        return left;
    }
    int rightChild(int parentIndex){
        int right = 2 * parentIndex + 2;
        if(right > root.size )
            return -1;
        return right;
    }
    int getMax(){
        if(root == null)
            return -1;
        return root.arr[0];
    }
    int deleteMax(){
        if(root == null)
            return -1;
        int val = root.arr[0];
        root.arr[0] = root.arr[root.size-1];
        root.size = root.size - 1;
        percolateDown(0);
        return  val;
    }

    public void percolateDown(int index){
        int l_ind = leftChild(index);
        int r_ind = rightChild(index);

        if(l_ind == -1 || r_ind == -1)
            return;

        int max_ind = index;
        if(root.arr[l_ind] > root.arr[index])
            max_ind = l_ind;

        if(root.arr[r_ind] > root.arr[max_ind]){
            max_ind = r_ind;
        }

        if(max_ind != index){
            int temp = root.arr[max_ind];
            root.arr[max_ind] = root.arr[index];
            root.arr[index] = temp;
        }
        else{
            return;
        }
        percolateDown(max_ind);

    }
    public void resizeHeap(){
        int[] oldArr = root.arr;
        int newCapacity = root.capacity * 2;
        int [] newArr = new int[newCapacity];
        for(int i = 0 ; i < root.size ;i++){
            newArr[i] = oldArr[i];
        }
        root.capacity = newCapacity;
        root.arr = newArr;

    }

    public void buildHeap(int [] arr){
        int n = arr.length;
        while(root.capacity < n){
            resizeHeap();
        }
        for(int i = 0 ; i < n ;i++){
            root.arr[i] = arr[i];
        }
        root.size = n;
        int first_leaf_node_parent = getParent(n-1);
        for(int i = first_leaf_node_parent; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public void insert(int val){
        if(root.size == root.capacity)
            resizeHeap();

        root.arr[root.size] = val;
        root.size = root.size + 1;
        int currIndex = root.size - 1;
        int parentIndex = getParent(currIndex);
        while(parentIndex != -1 && val > root.arr[parentIndex]){
            root.arr[currIndex] = root.arr[parentIndex];
            currIndex = parentIndex;
            parentIndex = getParent(currIndex);
        }
        root.arr[currIndex] = val;
    }

    public void sortHeap(){

    }


    public void print(){
        for(int i = 0 ; i < root.size; i++){
            System.out.print(root.arr[i] + "\t");
        }
        System.out.println("\n");
    }
}
