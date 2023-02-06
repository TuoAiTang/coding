

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null) return head;
        int len = len(head);
        k %= len;
        if(k == 0) return head;
        int preIndex = len - k;
        
        ListNode rest = head;
        ListNode pre = head;
        while(--preIndex > 0)
            pre = pre.next;
        
        ListNode p = pre.next;
        head = pre.next;
        
        pre.next = null;
        while(p.next != null)
            p = p.next;
        
        p.next = rest;
        return head;
    }
    
    public int len(ListNode head){
        int i = 0;
        while(head != null){
            i ++;
            head = head.next;
        }
        return i;
    }
}