class isSame_Subtree{
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
    //check two tree are indentical or not
    // T.C = O(n) ; S.C = O(n)
     public static boolean isIdentical(Node root,Node subRoot) {
        if(root == null || subRoot == null){
            return root == subRoot;
        }
        if(subRoot.data != root.data){
            return false;
        }
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
    //SubTree in Tree
    //T.C = O( n + m ) ; S.C = O( n + m ) => check identical -> o(m) and find root -> O(n)
    public static boolean isSubtree(Node root,Node subRoot) { 
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            //check if the subtrees of both are same
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String args[]){
        //TREE
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        //SUBTREE
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // subRoot.right.right = new Node(9);

        System.out.println("Subtree is there "+isSubtree(root, subRoot));
        System.out.println(isIdentical(root, subRoot));
        
    }
}