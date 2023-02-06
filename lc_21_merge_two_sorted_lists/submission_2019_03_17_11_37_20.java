

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            boolean flag = l1.val > l2.val;
            tail.next = flag ? l2 : l1;
            tail = tail.next;
            l1 = flag ? l1 : l1.next;
            l2 = flag ? l2.next : l2;
        }
        
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}