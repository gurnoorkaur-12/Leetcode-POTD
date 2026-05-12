import java.util.*;
    
class topView{

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

    static class Info{
        Node node;
        int hd;

        Info(Node node ,int hd) {
            this.node = node;
            this.hd = hd;
        }
        
    }

    //TOP VIEW OF A TREE
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        //( horizontal distance , node.data ) -> for top view nodes
        HashMap<Integer,Integer> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root,0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            //check for top node and add in map
            if(!map.containsKey(curr.hd)){
                min = Math.min(min,curr.hd);
                max = Math.max(max,curr.hd);
                map.put(curr.hd, curr.node.data);
            }

            if(curr.node.left != null){
                q.add(new Info( curr.node.left , curr.hd - 1));
            }
            if(curr.node.right != null){
                q.add(new Info( curr.node.right , curr.hd + 1));
            }
        }
        
        for(int i = min ; i <= max ; i++){
            System.out.print(map.get(i));
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // T.C = O(n) ; S.C = O(n);
        topView(root);
    }
}