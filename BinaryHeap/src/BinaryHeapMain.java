public class BinaryHeapMain {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10, 1);
        int[] nums = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        heap.buildHeap(nums);
        System.out.println("Printing heap");
        heap.print();
        System.out.println("Inserting an element 21 in the heap");
        heap.insert(21);
        heap.print();
        System.out.println("Max element in the heap : " + heap.getMax());
        System.out.println("Heap after deleting its max element");
        heap.deleteMax();
        heap.print();

    }
}
