import java.util.*;
    
class preOrderTraversal{
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

    public static void nodes(TreeNode root ,LinkedList list){
        if(root == null){
            return;
        }
        list.add(root.val);
        nodes(root.left,list);
        nodes(root.right,list);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        nodes(root , list);
        return list;

    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        List<Integer> list = preorderTraversal(root);
        while(!list.isEmpty()){
            System.out.println(list.removeFirst());
        }

    }
}