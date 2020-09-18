import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BinaryTreeMain {
    public static void main(String[] args){
        int [] arr = {24,12,34,56,11,23,45,16};
        /*
                          24
                        /   \
                       /     \
                      12      34
                      /\       \
                     /  \       \
                    11  23      56
                        /       /
                       /       /
                      16      45

         */
        BinaryTree bt = new BinaryTree(arr);
        System.out.println("Inorder tree traversal");
        bt.inorderTraversal(bt.getRoot());
        System.out.print("\n");
        System.out.println("PreOrder tree traversal");
        bt.preOrderTraversal(bt.getRoot());
        System.out.print("\n");
        System.out.println("Postorder tree traversal");
        bt.postOrderTraversal(bt.getRoot());
        System.out.print("\n");
        System.out.println("LevelOrder tree traversal");
        bt.levelOrderTraversal(bt.getRoot());
        System.out.println("Level order traversal printing each level in new lines");
        bt.levelOrderTraversal2(bt.getRoot());
        System.out.println("ZigZag Traversal");
        bt.zigZagTraversal(bt.getRoot());

        int sizeOfBinaryTree = bt.getNumNodes(bt.getRoot());
        System.out.println("\nSize of a binary tree : " + Integer.toString(sizeOfBinaryTree));

        ArrayList<Integer> path = new ArrayList<>();
        System.out.println("Find path to node");
        boolean isPathFound = bt.findPathToNode(bt.getRoot(),11,path);
        if(isPathFound){
            for(Integer i : path){
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }

        //Find LCA 11 and 16.
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        int node1 = 11;
        int node2 = 16;
        boolean isPathFound1 = bt.findPathToNode(bt.getRoot(),node1,path1);
        boolean isPathFound2 = bt.findPathToNode(bt.getRoot(),node2,path2);
        if(isPathFound1 && isPathFound2){
            int lca = bt.getRoot().val;
            Iterator<Integer> iter1 = path1.iterator();
            Iterator<Integer> iter2 = path2.iterator();
            while(iter1.hasNext() && iter2.hasNext()){
                if(iter1.next() == iter2.next()){
                    lca = iter1.next();
                }
            }
            System.out.println("Lowest common ancestor of " +  Integer.toString(node1) + " and " + Integer.toString(node2)  +" is : " + Integer.toString(lca));
        }
        else{
            System.out.println("Path to one of the nodes doesn't exists");
        }

        int max_element = bt.findMaxElement(bt.getRoot());
        System.out.println("Maximum element in the binary tree : " + Integer.toString(max_element));

        boolean search_element = bt.searchElement(bt.getRoot(),23);
        System.out.println("Found element : " + search_element);

        System.out.println("Reverse level order traversal");
        bt.reverseLevelOrderTraversal(bt.getRoot());

        System.out.println("Find height of a binary tree");
        int height = bt.findHeight(bt.getRoot());
        System.out.println(height);

        System.out.println("Printing leaf nodes");
        ArrayList<Integer> leafNode = bt.findLeafNodes(bt.getRoot());
        for(Integer i: leafNode)
            System.out.print(i + "\t");
        System.out.println("\nPrinting half nodes");
        ArrayList<Integer> halfNode = bt.findHalfNodes(bt.getRoot());
        for(Integer i: halfNode)
            System.out.print(i + "\t");
        System.out.println("\nPrinting full nodes");
        ArrayList<Integer> fullNode = bt.findFullNodes(bt.getRoot());
        for(Integer i: fullNode)
            System.out.print(i + "\t");

        System.out.println("\nPrint all leaf paths using array");
        int [] leafPaths = new int[256];
        bt.printAllLeafPaths(bt.getRoot(),0,leafPaths);
        System.out.println("Print all leaf paths using ArrayList");
        ArrayList<BinaryTreeNode> leafPaths2 = new ArrayList<>();
        bt.printAllLeafPaths2(bt.getRoot(),leafPaths2);

        System.out.println("Find vertical sum");
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        bt.findVerticalSum(bt.getRoot(), 0,hashMap);
        int size = hashMap.size();
        if(!hashMap.isEmpty()){
            Iterator<Map.Entry<Integer, Integer>> iter = hashMap.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<Integer,Integer> set = (Map.Entry<Integer,Integer>)iter.next();
                System.out.print(" { " + set.getKey() + "," + set.getValue() + " } ");
            }
            System.out.print("\n");
        }

        //Find sum of all elements.
        System.out.println("Sum of all the elements in a binary tree : " + bt.findSumOfAllElements(bt.getRoot()));

    }
}
