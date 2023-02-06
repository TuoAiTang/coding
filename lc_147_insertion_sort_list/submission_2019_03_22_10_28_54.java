

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = head.next;
        ListNode tail = head;
        ListNode pre, tmp;
        
        while(p != null){
            tmp = p.next;  
            if(tail.val <= p.val) {
                tail = p;
                p = tmp;
                continue;
            }
            pre = dummy;
            while(pre.next.val <= p.val)
                pre = pre.next;
            
            //insert between pre and pre.next
            tail.next = p.next;
            p.next = pre.next;
            pre.next = p;
            
            p = tmp;
        }
        
        return dummy.next;
    }
}