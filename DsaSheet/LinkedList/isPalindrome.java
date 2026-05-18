class isPalindrome{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);

        //reverse
        ListNode prev = null, curr = mid ,next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp = head;

        while(temp != null && prev != null){
            if(temp.val != prev.val) return false;

            temp = temp.next;
            prev = prev.next;
        }
        return true;
    }
    public static void main(String[] args) {
        // T.C = O(n) ; S.C = O(1);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

       System.out.println(isPalindrome(head));
    }
}