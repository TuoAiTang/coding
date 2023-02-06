

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode tail1 = dummy1, tail2 = dummy2;
        
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                tail1.next = p;
                tail1 = p;
            }else{
                tail2.next = p;
                tail2 = p;
            }
            p = p.next;
        }
        
        tail2.next = null;
        tail1.next = dummy2.next;
        
        return dummy1.next;
    }
}