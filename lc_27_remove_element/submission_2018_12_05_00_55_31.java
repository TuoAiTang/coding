

class Solution {
    public int removeElement(int[] nums, int val) {
        int l, r;
        l = r = 0;
        for(; r < nums.length; r++)
        	if(nums[r] != val)
        		nums[l++] = nums[r];
    	return l;
    }
}