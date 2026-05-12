class isBalanced{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if(left == -1 || right == -1){
            return -1;
        }

        if(Math.abs(left-right) > 1){
            return -1;
        }else{
            return Math.max(left ,right) +1;
        }


    }
    public static boolean isBalanced(TreeNode root) {
        if(height(root) == -1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        //T.C = O(n) S.C = O(n)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        // root.left.left.left = new TreeNode(7);
        // root.left.left.left.left = new TreeNode(7);

        System.out.println(isBalanced(root));
    }
}