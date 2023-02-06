

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
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(k-- > 0)
            fast = fast.next;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode tmp = head;
        head = slow.next;
        fast.next = tmp;
        slow.next = null;
        
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