import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    static class Node{
        int key;
        Node left;
        Node right;

        Node(int k){
            key = k;
        }
    }

    public static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty()== false) {
            Node curr = q.poll();
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }

    // get size of binary tree
    public static int getSize(Node root){
        if(root == null){
            return 0;
        }else{
            return 1+getSize(root.left)+getSize(root.right);
        }


    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);

       // levelOrder(root);
       // System.out.println(getSize(root));
    }
}