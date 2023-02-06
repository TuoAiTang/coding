

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode right = split(head);
        ListNode left = head;
        left = sortList(left);
        right = sortList(right);
        return mergeList(left, right);
    }
    
    public ListNode split(ListNode head){
        if(head == null || head.next == null) return head;
        int len = len(head);
        int n = len / 2 - 1;       
        while(n-- > 0)
            head = head.next;
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeList(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }
    
    public int len(ListNode p){
        int i = 0;
        while(p != null){
            p = p.next;
            i++;
        }
        return i;
    }
}