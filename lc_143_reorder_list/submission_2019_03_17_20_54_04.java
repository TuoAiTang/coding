

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        ListNode last = mid.next;
        if(last == null) return ;
        ListNode p = last.next, tmp;
        
        //reverse
        while(p != null){
            tmp = p.next;
            p.next = mid.next;
            mid.next = p;
            p = tmp;
        }
        
        last.next = null;
        
        //insert
        p = head;
        ListNode r = mid.next;
        while(r != null){
            tmp = r.next;
            r.next = p.next;
            p.next = r;
            p = r.next;
            r = tmp;
        }
        
        mid.next = null;
    }
}