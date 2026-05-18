import java.util.*;
class balanceBST{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void inOrder(TreeNode root , ArrayList<Integer> list){
        //T.C = O(n); S.C = O(n)
        if(root == null) {
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public static TreeNode sortedArrayToBST(ArrayList<Integer> list ,int st , int end){
        //T.C = O(n); S.C = O(n)
        if(st > end){
            return null;
        }
        int mid = st + ( end-st )/2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedArrayToBST(list ,st, mid-1);
        root.right = sortedArrayToBST(list ,mid + 1 ,end);

        return root;
    }

    public static TreeNode balanceBST(TreeNode root) {
        //T.C = O(n); S.C = O(n)
        
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return sortedArrayToBST(list , 0 , list.size()-1);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        root = balanceBST(root);
        ArrayList<Integer> list= new ArrayList<>();
        inOrder(root, list);
        for(Integer ele:list){
            System.out.println(ele);
        }
    }
}