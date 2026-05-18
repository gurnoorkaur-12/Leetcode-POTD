class middleLL{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Better approach
    // public static ListNode middleNode(ListNode head){
    //     ListNode temp = head;
    //     int length = 0;

    //     while(temp!=null){
    //         temp = temp.next;
    //         length++;
    //     }
    //     temp = head;
    //     for(int i = 0 ; i < length/2 ; i++){
    //         temp = temp.next;
    //     }
    //     return temp;
    // }
    //BEST approach
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
    public static void main(String[] args) {
        // T.C = O(n) ; S.C = O(1);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(middleNode(head).val);
    }
}