

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            dummy.next = head;
            pre = head;
            head = tmp;
        }
        
        return dummy.next;
    }
}