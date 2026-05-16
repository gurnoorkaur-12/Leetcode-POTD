class sortedArrayToBST{
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

    public static Node buildTree(Node root , int[] nums , int st , int end){

        if(st > end){
            return null;
        } 
        int mid = st + (end - st)/ 2;

        if(root == null){
            root = new Node(nums[mid]);
            root.left = buildTree(root.left , nums , st , mid-1);
            root.right = buildTree(root.right , nums , mid+1 , end);
        }
        
        return root;
    }
    public static Node sortedArrayToBST(int[] nums) {
        return buildTree(null , nums , 0 , nums.length-1);
    }
    public static void main(String args[]){
        // T.C = O(n); S.C = O(logn);
        Node root = sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
        inOrder(root);

    }
}