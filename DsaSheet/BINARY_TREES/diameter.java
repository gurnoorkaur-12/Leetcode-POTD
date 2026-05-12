class diameter{
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

    // T.C = O(n^2) ; S.c = O(n^2)
    
    // public static int diameter(Node root){
    //     if(root == null){
    //         return 0;
    //     }
    //     //max of diameter of left and right subtree
    //     int maxLR = Math.max(diameter(root.left), diameter(root.right) );

    //     //max of diameters of subtrees and diameter passing through root node
    //     return Math.max((1 + height(root.left) + height(root.right)) , maxLR);
    // }

        //OR
    //DIAMETER OF A TREE
    static int ans = 0;
    public static int diameterOfBinaryTree(Node root){
        if(root == null){
            //height = 0 ; diameter = 0;
            return 0;
        }
        int lh = diameterOfBinaryTree(root.left);
        int rh = diameterOfBinaryTree(root.right);
        int diameter = lh + rh + 1;

        ans = Math.max(ans,diameter);

        return Math.max(lh, rh) + 1;
    }
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // T.C = O(n) S.c = O(n)
        int dia = diameterOfBinaryTree(root);
        System.out.println(dia);
    }
}