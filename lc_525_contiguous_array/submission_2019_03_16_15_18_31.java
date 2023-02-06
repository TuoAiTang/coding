

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        //<sum, index>
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(sum == 0)
                ans = i + 1;
            else if(m.containsKey(sum))
                ans = Math.max(ans, i - m.get(sum));
            else
                m.put(sum, i);
        }
        
        return ans;
    }
}