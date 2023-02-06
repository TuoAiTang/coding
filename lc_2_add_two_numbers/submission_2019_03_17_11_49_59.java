

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
        return helper(l1, l2, 0);
    }
    
    public ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry == 1)
                return new ListNode(1);
            return null;
        }
        else{
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode n = new ListNode(sum % 10);
            carry = sum > 9 ? 1 : 0;
            n.next = helper(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, carry);
            return n;
        }
    }
}