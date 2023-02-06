

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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        int carry = 0;
        //头插法
        while(!s1.isEmpty() && !s2.isEmpty()){
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            ListNode p = new ListNode(sum);
            p.next = pre;
            dummy.next = p;
            pre = p;
        }
        
        Stack<Integer> s = s1.isEmpty() ? s2 : s1;
        
        while(!s.isEmpty()){
            int sum = s.pop() + carry;
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            ListNode p = new ListNode(sum);
            p.next = pre;
            dummy.next = p;
            pre = p;
        }
        
        if(carry == 1){
            ListNode p = new ListNode(1);
            p.next = pre;
            dummy.next = p;
        }

        return dummy.next;
    }
}