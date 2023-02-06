

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode spre = dummy;
        ListNode end = dummy;
        while(--m > 0)
            spre = spre.next;
        while(n-- > 0)
            end = end.next;
        
        ListNode end_right = end.next;
        end.next = null;
        ListNode p = spre.next;
        ListNode last = spre.next;
        while(p != null){
            ListNode tmp = p.next;
            p.next = spre.next;
            spre.next = p;
            p = tmp;
        }
        
        last.next = end_right;
        return dummy.next;    
    }
}