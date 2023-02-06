

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            int val = cur.val;
            ListNode p = cur.next;
            while(p != null && p.val == val){
                cur.next = p.next;
                p = p.next;
            }
            cur = p;
        }
        return head;
    }
}