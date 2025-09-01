class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // count length
        int d = 0;
        for (ListNode t = head; t != null; t = t.next) d++;

        ListNode dummy = new ListNode(-1), prev = dummy;
        dummy.next = head;

        while (d >= k) {
            prev.next = func(head, k);  // reverse k nodes
            prev = head;                // after reversal, head becomes end of group
            head = head.next;           // move to next group
            d -= k;
        }
        return dummy.next;
    }

    private ListNode func(ListNode head, int k) {
        ListNode prev = null, curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr; // connect tail to the next group
        return prev;      // new head of this reversed block
    }
}
