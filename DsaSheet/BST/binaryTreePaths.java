import java.util.*;
class binaryTreePaths{
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
    public static void getPath(Node root , List<String> list ,String path){
        if(root.left == null && root.right == null){
            list.add( path + root.val);
            path = new String();
            return;
        }
        if(root.left != null){
            getPath(root.left , list , path + root.val + "->");
        }
        if( root.right != null){
            getPath(root.right , list , path + root.val + "->");
        }   
    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> list = new ArrayList<>();
        String path = new String();

        getPath(root,list,path);
        return list;
    }
    //  public static void getPath(Node root , List<String> list, List<Integer> num){
    //     if(root == null){
    //         return;
    //     }

    //     num.add(root.val);
        
    //     if(root.left == null && root.right == null){
    //         StringBuilder sb = new StringBuilder();
    //         for(int i = 0 ; i < num.size() ; i++){
    //             if(i==0) sb.append(num.get(i));
    //             else { sb.append("->" + num.get(i)) ;}   
    //         }
    //         list.add(sb.toString());
    //     }

    //     getPath(root.left, list, num);
    //     getPath(root.right, list, num);
    //     num.remove(num.size()-1);
    // }
    // public static List<String> binaryTreePaths(Node root){
    //     List<String> list = new ArrayList<>();
    //     List<Integer> num= new ArrayList<>();

    //     getPath(root,list,num);
    //     return list;
    // }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        
        // T.C = O(n) ; S.C = O(n);
        List<String> list= binaryTreePaths(root);
        for(String ele:list){
            System.out.println(ele);
        }
    }
}