/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
        return false;
        ListNode t = head;
        Map<ListNode,Boolean> hm = new HashMap<>();
        while(t != null){
            if(hm.containsKey(t))
            return true;
            hm.put(t,true);
            t = t.next;
        }
        return false;
    }
}
