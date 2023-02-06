

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = 0;
        for(int i = 1; i <= n; i ++)
            x =  x ^ i ^ nums[i - 1];
        return x;
    }
}