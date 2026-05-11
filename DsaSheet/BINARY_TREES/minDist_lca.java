class minDist_lca{
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

    //MINIMUM DISTANCE BETWEEN TWO GIVEN NODES;
    //T.C = O(n) ; S.C = O(n)
    public static Node lca(Node root , int a , int b) {        
        if(root == null || root.data == a || root.data == b){
            return root;
        }
        Node left = lca(root.left , a , b);
        Node right = lca(root.right , a , b);
        
        if(left == null || right == null){
            return left == null ? right : left;
        }
       return root;
    }
    public static int getDist(Node root , int n){
        //finds distance between two nodes i.e parent and child
        if(root == null){
            return -1;
        }
        
        if(root.data == n){
            return 0;
        }
        
        int left = getDist(root.left ,n);

        if(left != -1){
            return left + 1;
        }

        int right = getDist(root.right , n);

        if(right != -1){
            return right + 1;//ode exists in right
        }
        return -1;//node does not exists in the subtree
    }
    
    public static int minDist(Node root, int a, int b) {
        Node lca = lca(root , a , b );
        //distance of lca from both nodes 
        return getDist(lca,a) + getDist(lca,b);
        
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(minDist(root, 4, 6));
    }
}