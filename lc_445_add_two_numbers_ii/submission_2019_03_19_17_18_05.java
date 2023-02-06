

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
        int len1 = len(l1);
        int len2 = len(l2);
        
        //确保l1 比 l2 长
        if(len1 < len2){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
            int len = len1;
            len1 = len2;
            len2 = len;
        }
        
        int carry = helper(l1, len1, l2, len2);
        if(carry == 1){
            ListNode p = new ListNode(1);
            p.next = l1;
            return p;
        }
        
        else
            return l1;
    }
    
    //计算后面的计算传递上来的carry
    //改变当前的值
    public int helper(ListNode l1, int len1, ListNode l2, int len2){
        if(l1 == null && l2 == null) return 0;
        if(len1 > len2){
            int carry = helper(l1.next, len1 - 1, l2, len2);
            int sum = l1.val + carry;
            l1.val = sum % 10;
            return sum > 9 ? 1 : 0;
        }
        //因为l1比l2长，多以只有可能 len1 == len2
        else{
            int carry = helper(l1.next, len1 - 1, l2.next, len2 - 1);
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            return sum > 9 ? 1 : 0;
        }
    }
    
    public int len(ListNode h){
        int i = 0;
        while(h != null){
            i++;
            h = h.next;
        }
        return i;
    }
}