import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // get max value
    public static int getMax(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
        }
    }

    // itrative inorder traversal
    public static void itrativeTraversal(Node root){
        Stack<Node> st = new Stack<Node>();
        Node curr = root;
        while (curr != null || st.isEmpty() == false)  {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.key +" ");
            curr = curr.right;
        }
    }

    // itrative preOrder
    public static void preOrderTraversal(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while (st.isEmpty() == false) {
            Node curr  = st.pop();
            System.out.print(curr.key+" ");

            if(curr.right != null){
                st.push(curr.right);

            }
            if(curr.left != null){
                st.push(curr.left);
            }
        }

    }

    // itrative pre Order traversal optamize space

    public static void preOrderOptamize(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<Node>();
        Node  curr = root;

        while (curr != null || st.isEmpty() == false) {
            while (curr != null) {
                System.out.print(curr.key+" ");
                if(curr.right != null){
                    st.push(curr.right);
                }
                curr = curr.left;
            }
            if(st.isEmpty() == false){
                curr = st.pop();
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);

       // levelOrder(root);
       // System.out.println(getSize(root));
       // System.out.println(getMax(root));

       // itrativeTraversal(root);
       // preOrderTraversal(root);
       preOrderOptamize(root);


    }
}