/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hedA = headA;
        ListNode hedB = headB;
        while(hedA !=  hedB){
            hedA = hedA == null ? headB : hedA.next;
            hedB = hedB == null ? headA : hedB.next;
        }
        return hedA;
    }
}
