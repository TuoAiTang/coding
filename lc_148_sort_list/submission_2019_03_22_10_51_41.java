

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
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
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