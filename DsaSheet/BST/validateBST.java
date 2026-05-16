class validateBST{
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isBST(Node root , Node min , Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return isBST(root.left,min,root) && isBST(root.right,root,max);
    }
    
    public static boolean isValidBST(Node root) {
        return isBST(root,null,null);
    }
    public static void main(String[] args) {
        // T.C = O(n); S.C = O(h);
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        System.out.println(isValidBST(root));
    }
}