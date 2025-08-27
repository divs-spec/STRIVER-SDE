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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int d = 1;
        while(temp.next != null){
            ++d;
            temp = temp.next;
        }
        d /= 2;
        temp = head;
        while(d > 0){
            --d;
            temp = temp.next;
        }
        return temp;
    }
}
