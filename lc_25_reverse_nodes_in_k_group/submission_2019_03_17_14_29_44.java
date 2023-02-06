

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode next_head = dummy;
        ListNode p = head;
        int res = len(head);
        while(res >= k){
            int n = k;
            //reverse k nodes
            ListNode pre = null;
            ListNode cur_head = next_head;
            next_head = p;
            while(n-- > 0){
                cur_head.next = p;
                ListNode tmp = p.next;
                p.next = pre;
                pre = p;
                p = tmp;   
            } 
            res -= k;
        }
        
        next_head.next = p;
        return dummy.next;
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