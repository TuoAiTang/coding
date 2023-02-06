

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode less_tail = dummy;
        ListNode greater_start = null;
        ListNode greater_tail = null;
        ListNode cur = head;
        
        while(cur != null && cur.val < x){
            less_tail = cur;
            cur = less_tail.next;
        }
        
        greater_start = greater_tail = cur;
        
        while(cur != null){
            if(cur.val < x){
                ListNode p = cur.next;
                less_tail.next = cur;
                less_tail = cur;
                cur.next = greater_start;
                greater_tail.next = p;
            }else
                greater_tail = cur;
            cur = greater_tail.next;
        }
        
        return dummy.next;
    }
}