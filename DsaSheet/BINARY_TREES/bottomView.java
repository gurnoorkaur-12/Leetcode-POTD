import java.util.*;
class bottomView{
    
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

    static class Info{
        Node node;
        int hd;
        Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    // T.C = O(n) ; S.C = O(n)
    public static ArrayList<Integer> bottomView(Node root) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Info> q = new LinkedList<>();
        int min = 0 , max = 0; 
        
        q.add(new Info(root,0));
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            
            map.put(curr.hd,curr.node.data);
            min = Math.min(min,curr.hd);
            max = Math.max(max,curr.hd);
            
            if(curr.node.left != null){
                q.add(new Info(curr.node.left,curr.hd-1));
            }
            if(curr.node.right != null){
                q.add(new Info(curr.node.right,curr.hd+1));
            }
            
        }
        
        for(int i = min ; i <= max ; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        ArrayList<Integer> list = bottomView(root);
        for(Integer ele : list){
            System.out.println(ele);
        }
    }
}