

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int [] set = new int[10000];
        for(int val : G)
        	set[val] = 1;
        int ans = 0;
        while(head != null){
            if(set[head.val] == 1 && (head.next == null || set[head.next.val] == 0))
                ans++;
            head = head.next;
        }
        return ans;
    }
}