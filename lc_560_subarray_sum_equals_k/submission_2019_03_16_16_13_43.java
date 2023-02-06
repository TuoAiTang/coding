

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //<sum, count>
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(m.containsKey(sum - k))
                ans += m.get(sum - k);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}