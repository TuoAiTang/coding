

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = nums[0];
        for(int i = 0; i < n; i++){
            if(i > reach) return false;
            if(reach >= n - 1) return true;
            reach = Math.max(reach, i + nums[i]);
        }
        return false;
    }   
}