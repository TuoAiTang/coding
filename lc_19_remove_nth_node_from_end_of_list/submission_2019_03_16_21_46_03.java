

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = len(head);
        if(len == 0) return null;
        
        //n is not valid, just return head
        if(n <= 0 || n > len) return head;
        int pre = len - n;
        if(pre == 0)
            return head.next;
        
        ListNode preNode = head;
        while(--pre > 0)
            preNode = preNode.next;
        preNode.next = preNode.next.next;
        return head;
    }
    
    public int len(ListNode head){
        int i = 0;
        while(head != null){
            i++;
            head = head.next;
        }
        return i;
    }
}