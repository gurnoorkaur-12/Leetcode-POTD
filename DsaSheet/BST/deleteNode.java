class deleteNode{
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
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "\t");
        inOrder(root.right);
    }

    
    public static Node inorderSucc(Node root){
        if(root.left == null){
            return root;
        }
        return inorderSucc(root.left);
    }
    public static Node delete(Node root , int key) {
        if(root == null){
            return null;
        }

        if(root.val == key){
            if(root.left == null && root.right == null){
                //0 children
                return null;
            }else if(root.left == null || root.right == null){
                //1 children
                return root.left != null ? root.left : root.right;
            }else{
                //2 children
                Node inorderS = inorderSucc(root.right);
                root.val = inorderS.val;
                root.right = delete(root.right, inorderS.val);

            }

        }else if(root.val > key){
            root.left = delete(root.left,key);
        }else{
            root.right = delete(root.right, key);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        inOrder(root);
        System.out.println("");

        // T.C = O(H) ; S.C = O(H) => H = height of tree;
        delete(root, 5);
        inOrder(root);
    }
}