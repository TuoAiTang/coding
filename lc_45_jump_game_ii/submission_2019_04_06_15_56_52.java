

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int i = 0;
        int curMax = 0;
        int nextMax = nums[0];
        int ans = 0;
        while(nextMax != curMax){
            curMax = nextMax;
            ans++;
            if(curMax >= n - 1)
                return ans;
            while(++i <= curMax)
                nextMax = Math.max(nextMax, i + nums[i]);
            i--;
        }
        return -1;
    }
}