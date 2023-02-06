

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
        Set<Integer> s = new HashSet<>();
        for(int num : G)
            s.add(num);
        
        boolean flag = false;
        int ans = 0;
        while(head != null){
            if(s.contains(head.val)){
                ans += flag ? 0 : 1;
                flag = true;
            }
            else
                flag = false;
            head = head.next;
        }
        return ans;
    }
}