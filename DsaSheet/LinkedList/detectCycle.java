class detectCycle{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    //T.C = O(n); S.C = O(1);
    //LinkedList Cycle - I
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head , fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        
        return false;
    }

    //T.C = O(n); S.C = O(1);
    //LinkedList Cycle - II
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head , fast = head;
        boolean hasCycle = false;

        //check if cycle exists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            } 
        }
        if(!hasCycle) return null;

        //find the start node of cycle
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        //LinkedList Cycle -I
        System.out.println(hasCycle(head));
        
        //LinkedList Cycle -II
        System.out.println(detectCycle(head).val);
    }
}