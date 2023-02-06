

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);
            int mod = (x + y + carry) % 10;
            ListNode p = new ListNode(mod);
            tail.next = p;
            tail = p;
            carry = (x + y + carry) > 9 ? 1 : 0;
            l1 = (l1 == null ? l1 : l1.next);
            l2 = (l2 == null ? l2 : l2.next);
        }
        
        if(carry == 1){
            ListNode p = new ListNode(1);
            tail.next = p;
            tail = p;
        }
  
        return dummy.next;
    }
}