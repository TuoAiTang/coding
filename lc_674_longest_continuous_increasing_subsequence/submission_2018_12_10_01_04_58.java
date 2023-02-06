

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int cur = 1;
        int ans = 1;
     	for(int i = 1; i < nums.length; i++){
     		if(nums[i] > nums[i - 1])
     			++cur;
     		else{
     			ans = Math.max(cur, ans);
     			cur = 1;
     		}
     	}
     	return Math.max(ans, cur);
    }
}