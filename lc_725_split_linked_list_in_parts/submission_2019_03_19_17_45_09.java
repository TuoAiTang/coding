

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int index = 0;
        ListNode [] res = new ListNode[k];
        int len = len(root);
        int extra = len % k;
        int size = len / k;
        int step = 0;
                 
        ListNode tmp;
        while(extra-- > 0){
            step = size + 1;
            res[index++] = root;
            while(--step > 0)
                root = root.next;
            tmp = root.next;
            root.next = null;
            root = tmp;
        }
              
        int rest = k - index;
        while(rest-- > 0){
            step = size;
            res[index++] = root;
            if(root != null){
                while(--step > 0)
                    root = root.next;
                tmp = root.next;
                root.next = null;
                root = tmp;
            }
        }
        
        return res;
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