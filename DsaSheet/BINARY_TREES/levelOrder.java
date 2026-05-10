import java.util.*;
class levelOrder{

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
 
    //Iterative method
    // public static List<List<Integer>> levelOrder(TreeNode root) {
        
    //     List<Integer> ll = new LinkedList<>();
    //     List<List<Integer>> list = new LinkedList<>();
    //     Queue<TreeNode> q = new LinkedList<>();

    //     if(root == null){
    //         return list;
    //     }
    //     q.add(root);
    //     q.add(null);

    //     while(!q.isEmpty()) {
    //         TreeNode node = q.remove();
    //         if( node == null ){
    //             if(!q.isEmpty()){
    //                 q.add(null);
    //             }
    //             list.add(ll);
    //             ll = new LinkedList<>();
    //         }else{

    //             ll.add(node.val);
    //             if(node.left != null){
    //                 q.add(node.left);
    //             }
    //             if(node.right != null){
    //                 q.add(node.right);
    //             }
    //         }
    //     }
    //     return list;
    // }
    // public static List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> list = new LinkedList<>();
    //     if(root == null) return list;

    //     LinkedList<Integer> ll = new LinkedList<>();
    //     Queue <TreeNode> q = new LinkedList<>();

    //     q.add(root);

    //     while(!q.isEmpty()){
    //         int n = q.size();
    //         ll = new LinkedList<>();
    //         for(int i = 0 ; i < n ; i++){
    //             TreeNode node = q.remove();
    //             ll.add(node.val);

    //             if(node.left != null){
    //                 q.add(node.left);
    //             }

    //             if(node.right != null){
    //                 q.add(node.right);
    //             }
    //         }
    //         list.add(ll);
    //     }
    //     return list;
    // }
    public static void fillLevel(TreeNode root , List<List<Integer>> list, int level) {
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add(new LinkedList<>());
        }
        list.get(level).add(root.val);

        fillLevel(root.left,list,level+1);
        fillLevel(root.right,list,level+1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new LinkedList<>();
        fillLevel(root,list,0);
        
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        //  T.C = O(n) S.C = O(n)
        //USING ITERATIVE APPROACH
        List<List<Integer>> list = levelOrder(root);
        for(List<Integer> ll : list){
            for(int ele : ll){
                System.out.print(ele+"\t");
            }
            System.out.println();
        }
    }
}