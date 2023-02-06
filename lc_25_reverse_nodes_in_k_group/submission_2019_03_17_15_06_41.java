

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
        int i = 0;
        ListNode next_head = head;
        while(i++ < k){
            if(next_head == null) return head;
            next_head = next_head.next;
        }
        
        ListNode last = head;
        ListNode p = head.next;
        for(int j = 0; j < k - 1; j++){
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        
        last.next = reverseKGroup(next_head, k);
        return head;
    }
   
}