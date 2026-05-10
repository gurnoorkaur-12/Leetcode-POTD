class isSymmetric{
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
    public static boolean checkLR(TreeNode root1 , TreeNode root2){
        if(root1 == null || root2 == null ){
            return root1 == null && root2 == null ;
        }

        if(root1.val != root2.val){
            return false;
        }

        return checkLR(root1.left,root2.right) && checkLR(root1.right,root2.left);

    }
    public static boolean isSymmetric(TreeNode root) {

        return checkLR(root.left , root.right);
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
        boolean ans = isSymmetric(root);
        System.out.println(ans);
        
    }
}