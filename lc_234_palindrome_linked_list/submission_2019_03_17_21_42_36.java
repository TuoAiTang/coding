

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        if(mid == null) return true;
        ListNode p = head;
        ListNode q = reverse(mid);
        while(q != null){
            if(p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode newhead = null, tmp;
        while(head != null){
            tmp = head.next;
            head.next = newhead;
            newhead = head;
            head = tmp;
        }
        return newhead;
    }
}