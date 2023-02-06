

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
        ListNode pre = dummy;

        int len = n - m + 1;
        while(--m > 0)
            pre = pre.next;
        
        ListNode last = pre.next;
        ListNode cur = last.next;
        
        while(--len > 0){
            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
        }
        
        last.next = cur;
        
        return dummy.next;    
    }
}