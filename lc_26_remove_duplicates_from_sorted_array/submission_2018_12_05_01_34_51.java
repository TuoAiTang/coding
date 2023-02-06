

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int l, r;
        l = r = 1;
        for(; r < nums.length; r++){
        	if(nums[r] != nums[l - 1])
        		nums[l++] = nums[r];
        }
        return l;
    }
}