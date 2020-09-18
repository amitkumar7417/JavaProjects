import java.util.*;

class BinaryTreeNode{
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}


public class BinaryTree {
    private BinaryTreeNode root;
    public BinaryTree(int[] arr){
        //Create a binary tree from arr
        for(int val: arr)
            insert(val);
    }

    public BinaryTreeNode getRoot(){
        return root;
    }

    public void insert(int val){
        //Create binary search tree
        BinaryTreeNode newNode = new BinaryTreeNode(val);
        if(root == null){
            root = newNode;
            return;
        }
        BinaryTreeNode tmp = root;
        int whichChild = 0;
        BinaryTreeNode parent = null;
        while(tmp != null){
            whichChild = 0;
            parent = tmp;
            if(val < tmp.val){
                tmp = tmp.left;
                whichChild = -1;
            }
            else{
                tmp = tmp.right;
                whichChild = 1;
            }
        }

        if(whichChild == -1/*leftChild*/){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
        }
    }

    public void inorderTraversal(BinaryTreeNode root){
        if(root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + "\t");
        inorderTraversal(root.right);
    }

    public void preOrderTraversal(BinaryTreeNode root){
        if(root == null)
            return;
        System.out.print(root.val + "\t");
        inorderTraversal(root.left);
        inorderTraversal(root.right);

    }
    public void postOrderTraversal(BinaryTreeNode root){
        if(root == null)
            return;
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        System.out.print(root.val + "\t");

    }

    public void levelOrderTraversal(BinaryTreeNode root){
        if(root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.peek();
            System.out.print(node.val + "\t");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            queue.poll();
        }
        System.out.println("\n");
    }

    public void levelOrderTraversal2(BinaryTreeNode root){
        if(root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            if(node == null){
                System.out.print("\n");
                if(queue.peek() != null) {
                    queue.add(null);
                }
            }
            else{
                System.out.print(node.val + "\t");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void zigZagTraversal(BinaryTreeNode root){
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();
        boolean leftToRight =  true;
        s1.push(root);
        while(!s1.isEmpty()){
            while(!s1.isEmpty()) {
                BinaryTreeNode node = s1.pop();
                System.out.print(node.val + "\t");
                if (leftToRight) {
                    if (node.left != null)
                        s2.push(node.left);
                    if (node.right != null)
                        s2.push(node.right);
                } else {
                    if (node.right != null)
                        s2.push(node.right);
                    if (node.left != null)
                        s2.push(node.left);
                }
            }
            leftToRight = !leftToRight;
            //Swap Stacks
            Stack<BinaryTreeNode> tmp = s2;
            s2 = s1;
            s1 = tmp;
        }
    }

    public static int getNumNodes(BinaryTreeNode root){
        if(root == null)
            return 0;
        return  1+getNumNodes(root.left)+getNumNodes(root.right);
    }

    public boolean findPathToNode(BinaryTreeNode root, int val,ArrayList<Integer> path){
        if(root == null)
            return false;

        path.add(root.val);
        //PreOrder Traversal
        if(root.val == val){
           return true;
        }
        if(findPathToNode(root.left,val,path) ||
        findPathToNode(root.right,val,path))
            return true;

       path.remove(path.size()-1);
       return false;
    }

    public int findMaxElement(BinaryTreeNode root){
        int max_element = Integer.MIN_VALUE;
        if(root != null) {
            int val = root.val;
            int left_max = findMaxElement(root.left);
            int right_max = findMaxElement(root.right);
            int branch_max = left_max > right_max ? left_max : right_max;
            max_element = branch_max > val ? branch_max : val;
        }
        return max_element;
    }

    public boolean searchElement(BinaryTreeNode root,int val){
        if(root == null)
            return false;

        if(root.val == val)
            return true;
        if(searchElement(root.left,val) || searchElement(root.right,val))
            return true;
        return false;
    }

    public void reverseLevelOrderTraversal(BinaryTreeNode root){
        Queue<BinaryTreeNode> q = new LinkedList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode node = q.poll();
            if(node.right != null)
                q.offer(node.right);
            if(node.left != null)
                q.offer(node.left);
            s.push(node);
        }

        while(!s.isEmpty()){
            System.out.print(s.pop().val + "\t");
        }
        System.out.print("\n");
    }

    public int findHeight(BinaryTreeNode root){
        if(root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    ArrayList<Integer> findLeafNodes(BinaryTreeNode root){
        ArrayList<Integer> leafNodes = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeNode node = q.poll();
            if(node.left == null && node.right == null)
                leafNodes.add(node.val);
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
        return leafNodes;
    }

    ArrayList<Integer> findFullNodes(BinaryTreeNode root){
        ArrayList<Integer> fullNodes = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeNode node = q.poll();
            if(node.left != null && node.right != null)
                fullNodes.add(node.val);
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
        return fullNodes;
    }

    ArrayList<Integer> findHalfNodes(BinaryTreeNode root){
        ArrayList<Integer> halfNodes = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeNode node = q.poll();
            if((node.left != null && node.right == null) || (node.left == null && node.right != null))
                halfNodes.add(node.val);
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
        return halfNodes;

    }

    boolean isStructurallySimilar(BinaryTreeNode root1 , BinaryTreeNode root2){
        if(root1 == null && root2 == null) {
            return true;
        }

        if((root1 == null && root2 != null) ||(root1 != null && root2 == null)){
            return false;
        }

        if(root1.val != root2.val)
            return false;

        isStructurallySimilar(root1.left,root2.left);
        isStructurallySimilar(root1.right,root2.right);
        return true;
    }

    void printAllLeafPaths(BinaryTreeNode root,int pathLen ,int [] path){
        if(root == null)
            return;
        path[pathLen++] = root.val;
        if(root.left == null && root.right == null){
            for(int i = 0; i < pathLen; ++i){
                System.out.print(path[i] + "\t");
            }
            System.out.print("\n");
        }

        printAllLeafPaths(root.left,pathLen,path);
        printAllLeafPaths(root.right,pathLen,path);

    }

    void printAllLeafPaths2(BinaryTreeNode root,ArrayList<BinaryTreeNode> path){
        if(root == null)
            return;
        path.add(root);
        if(root.left == null && root.right == null){
            for(BinaryTreeNode n : path){
                System.out.print(n.val + "\t");
            }
            System.out.print("\n");
        }
        printAllLeafPaths2(root.left,path);
        printAllLeafPaths2(root.right,path);
        path.remove(path.size()-1);
    }

    void findVerticalSum(BinaryTreeNode root,int column ,HashMap<Integer,Integer> hashMap){
        if(root == null)
            return;

        if(hashMap.get(column) != null){
            int val = hashMap.get(column);
            val = val + root.val;
            hashMap.put(column,val);
        }
        else{
            hashMap.put(column,root.val);
        }
        findVerticalSum(root.left,column-1,hashMap);
        findVerticalSum(root.right,column+1,hashMap);

    }

    int findSumOfAllElements(BinaryTreeNode root){
        if(root == null)
            return 0;

        return root.val+findSumOfAllElements(root.left)+findSumOfAllElements(root.right);
    }




}
