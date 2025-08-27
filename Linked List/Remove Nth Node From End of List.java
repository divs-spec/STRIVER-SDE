/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int d = 1;
        while(temp.next != null){
            ++d;
            temp = temp.next;
        }
        
        if (n == d) {
            return head.next;
        }

        temp = head;
        d = d- n;
        while(d > 1){
            --d;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
