

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int l, r;
        l = r = 0;
        nums[l++] = nums[0];
        for(; r < nums.length - 1; r++){
        	if(nums[r] != nums[r + 1])
        		nums[l++] = nums[r + 1];
        }
        return l;
    }
}