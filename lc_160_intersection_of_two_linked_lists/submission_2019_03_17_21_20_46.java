

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
        ListNode p = headA, q = headB;
        if(p == null || q == null) return null;
        
        while(p != null || q != null){ 
            if(p == q) return p;   
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return null;
    }
}