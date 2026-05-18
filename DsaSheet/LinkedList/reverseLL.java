class reverseLL{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //REVERSE - I
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null ,curr = head , next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //REVERSE -II
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //made dummy node to make it prev if left == head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0 ; i < left - 1 ; i++){
            //get prev pointer to element just prev of left pointer;
            prev = prev.next;
        }

        //tail is the left node which will become last element of reversed part
        //one by one nodes are made next of prev (temp)
        ListNode tail = prev.next , temp = prev.next;

        //move nodes before left 
        for(int i = 0 ; i < right - left ; i++){
           prev.next = tail.next;
           tail.next = tail.next.next;
           prev.next.next = temp;
           temp = prev.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // T.C = O(n);  S.C = O(1);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //REVERSE - I
        // head = reverseList(head);

        //REVERSE - II
        //T.C = O(n) ; S.C = O(1);
        head = reverseBetween(head,2,4);

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

        
        
    }
}