

class Solution {
    public int lengthOfLIS(int[] nums) {
    	int n = nums.length;
    	if(n == 0) return 0;
        int [] mem = new int [n];
		int ans = 1;
		for(int i = 0; i < n; i++)
			ans = Math.max(ans, LIS(nums, i, mem));
		return ans;
    }

    private int LIS(int [] nums, int end, int [] mem){
    	if(end == 0) return 1;
    	if(mem[end] > 0) return mem[end];

    	int ans = 1;
    	for(int i = 0; i < end; i++)
    		if(nums[end] > nums[i])
    			ans = Math.max(ans, LIS(nums, i, mem) + 1);
		mem[end] = ans;
		return ans;
    }
}