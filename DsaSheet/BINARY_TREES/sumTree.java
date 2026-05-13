import java.util.*;

class sumTree{
    public static class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int data) { this.data = data; }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            //when a node is null it means the all immediate childs of top level are stored and now will move to next level after this so print in new line
            if(currNode == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    } 

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int val = root.data;
        root.data = sum(root.left) + sum(root.right);

        return val + root.data;
    }
    public static void toSumTree(Node root){
        sum(root);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        toSumTree(root);
        levelOrder(root);
    }
}