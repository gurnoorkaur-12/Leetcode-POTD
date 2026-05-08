class oddEvenLL{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode oddEvenList(ListNode head){
        ListNode odd =  head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        //make even and odd linked list together 
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next =  odd.next;
            even = even.next;
        }
        //merge both linked lists
        odd.next = evenHead;
        return head;
    } 
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode val = oddEvenList(head);
        while(val!=null){
            System.out.println(val.val);
            val = val.next;
        }
        
    }
}