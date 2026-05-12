import java.util.*;

class kthLevel{

     static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void kthLevel(Node root, int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;

        if(level == k){
            System.out.println(root.data);
            return;
        }   
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(!q.isEmpty()){
                    level++;
                    if(level == k){
                        break;
                    }
                    q.add(null);
                }
            }else{
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        if(level < k){
            System.out.println("null");
        }else{
            while (!q.isEmpty()) { 
                System.out.print(q.peek().data+" \t ");
                q.remove();
            }
        }
        System.out.println("");
    }

    // RECURSIVE => Kth Level
    // public static void kthLevel(Node root,int k,int level){
    //     if(root == null){
    //         return;
    //     }
    //     if(level == k){
    //         System.out.print(root.data + " \t");
    //         return;
    //     }
    //     kthLevel(root.left, k, level+1);
    //     kthLevel(root.right, k, level+1);
    // }

    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // T.C = O(n) ; S.C = O(n)
        kthLevel(root, 3);
    }
}