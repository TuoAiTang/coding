

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode tail = null;
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            tail = head;
            return head;
        }
        ListNode rest = reverseList(head.next);
        head.next = null;
        tail.next = head;
        tail = head;
        return rest;
    }
}