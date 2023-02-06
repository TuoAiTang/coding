

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int l, r;
        l = r = 2;
        for(; r < nums.length; r++)
        	if(nums[r] != nums[l - 2])
        		nums[l++] = nums[r];
        return l;
    }
}