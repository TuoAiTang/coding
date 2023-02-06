

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] memo = new int [n];
        Arrays.fill(memo, -1);
        return reachable(0, nums, memo) >= nums.length - 1;
    }
    
    public int reachable(int i, int [] nums, int [] memo){
        if(memo[i] != -1) return memo[i];
        int index = i;
        for(int j = 1; j <= nums[i]; j++){
            if(i + j >= nums.length - 1) return nums.length - 1;
            index = Math.max(index, reachable(i + j, nums, memo));
        }
        return memo[i] = index;
    }
}