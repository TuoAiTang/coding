

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return getScores(nums, 0, nums.length - 1) >= 0;
    }

    //Space: O(n)  <- n, the recusion depth;
    private int getScores(int [] nums, int l, int r){
    	if(l == r) return nums[l];
    	return Math.max(nums[l] - getScores(nums, l + 1, r),
    					nums[r] - getScores(nums, l, r - 1));
    }
}