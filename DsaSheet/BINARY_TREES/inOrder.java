import java.util.*;
class inOrder{
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
 
    public static void inOrder(TreeNode root , List<Integer> list){
        if(root == null) return;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        inOrder(root,list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        List<Integer> list = inorderTraversal(root);
        for(int ele : list){
            System.out.print(ele +"\t");
        }
    }
}