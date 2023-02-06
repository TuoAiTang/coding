

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = head, p2 = head.next, pre = dummy;
        while(p1 != null && p2 != null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1.next = tmp;
            pre.next = p2;
            pre = p1;
            p1 = p1.next;
            p2 = p1 == null ? null : p1.next;
        }
        return dummy.next;
    }
}