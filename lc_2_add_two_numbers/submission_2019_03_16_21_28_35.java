

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
        ListNode a = l1;
        ListNode b = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(a != null && b != null){
            int x = a.val;
            int y = b.val;
            int mod = (x + y + carry) % 10;
            ListNode p = new ListNode(mod);
            tail.next = p;
            tail = p;
            carry = (x + y + carry) > 9 ? 1 : 0;
            a = a.next;
            b = b.next;
        }
        
        ListNode rest = (a == null) ? b : a;
        while(rest != null){
            int x = rest.val;
            int mod = (x + carry) % 10;
            ListNode p = new ListNode(mod);
            tail.next = p;
            tail = p;
            carry = (x + carry) > 9 ? 1 : 0;
            rest = rest.next; 
        }
        
        if(carry == 1){
            ListNode p = new ListNode(1);
            tail.next = p;
            tail = p;
        }
  
        return dummy.next;
    }
}