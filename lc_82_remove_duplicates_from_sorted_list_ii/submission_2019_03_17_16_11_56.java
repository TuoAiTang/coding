

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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            int val = cur.val;
            if(cur.next != null && cur.next.val == val){
                while(cur != null && cur.val == val)
                    cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}