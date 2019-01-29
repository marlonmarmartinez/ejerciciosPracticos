package ejerciciospracticas4;

import java.util.LinkedList;
import java.util.Queue;



public class TreeHeight {
    Node root; 
    public static void main(String[] args) {
        //BinaryTree tree = new BinaryTree(); 
        TreeHeight tree = new TreeHeight();
          
        // Let us create a binary tree shown in above diagram 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(1);
        System.out.println("Height of tree is " + tree.solution2(tree.root));
        //System.out.println("Height of tree is " + tree.treeHeight(tree.root));
    
    }
     public  int solution2(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(solution2(node.left), solution2(node.right));
    }
    }
    
    class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right; 
    } 
} 
   
class BinaryTree  
{ 
    Node root; 
   
    // Iterative method to find height of Bianry Tree 
    int treeHeight(Node node)  
    { 
        // Base Case 
        if (node == null) 
            return 0; 
   
        // Create an empty queue for level order tarversal 
        Queue<Node> q = new LinkedList(); 
   
        // Enqueue Root and initialize height 
        q.add(node); 
        int height = 0; 
   
        while (1 == 1)  
        { 
            // nodeCount (queue size) indicates number of nodes 
            // at current lelvel. 
            int nodeCount = q.size(); 
            if (nodeCount == 0) 
                return height; 
            height++; 
   
            // Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
            while (nodeCount > 0)  
            { 
                Node newnode = q.peek(); 
                q.remove(); 
                if (newnode.left != null) 
                    q.add(newnode.left); 
                if (newnode.right != null) 
                    q.add(newnode.right); 
                nodeCount--; 
            } 
        } 
    }
//----------------------------------------------------
    public int maxHeight(Arbol T) {
        int t1l = 0;
        int t2l = 0;

        if (T.l != null) {
            t1l = 1 + maxHeight(T.l);
        }
        if (T.r != null) {
            t2l = 1 + maxHeight(T.r);
        }

        return Math.max(t1l, t2l);
    }


    public static int solution1(Arbol T) {
        if (T == null) {
            return -1;
        }
        int result = 0;
        //result = Math.max(result, 1+solution(T.l));
        result = Math.max(result, 1 + solution1(T.r));
        return result;
    }

    private static class Arbol {

        public static int x;
        public static Arbol l;
        public static Arbol r;
    }
}
