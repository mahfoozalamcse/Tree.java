public class BinaryTree {
     static class Node{
       int key;
       Node left;
       Node right;

       Node(int k){
         key = k;
       }
    }

    // inOrder traversal 
    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);
        }
    }

    // preOrder traversal 
    public static void preOrder(Node root){
        if(root != null){
            
            System.out.print(root.key+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // posOrder traversal
    public static void posOrder(Node root){
        if(root != null){
            
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.key+" ");
        }
    }
    
    public static int height(Node root){
        if(root == null){
            return 0;
        }else{
        return Math.max(height(root.left), height(root.right))+1;
    }
   } 

   // print K distance Node
   public static void printKDist(Node root, int K){
    if(root == null) return;
    if(K == 0){
        System.out.print(root.key+" ");
    }else{
        printKDist(root.left, K-1);
        printKDist(root.right, K-1);
    }
   }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);
        
       // inOrder(root);
      //  preOrder(root);
      //  posOrder(root);
      // System.out.println(height(root));
      printKDist(root, 1);

        // Node root = null; // it means nothing in tree.

    }
}