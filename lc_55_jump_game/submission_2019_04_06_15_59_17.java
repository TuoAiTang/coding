

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n < 2) return true;
        int i = 0;
        int curMax = 0;
        int nextMax = nums[0];
        while(nextMax != curMax){
            curMax = nextMax;
            if(curMax >= n - 1)
                return true;
            while(++i <= curMax)
                nextMax = Math.max(nextMax, i + nums[i]);
            //i = curMax + 1
            i--;
            //i = curMax
        }
        return false;
    }   
}