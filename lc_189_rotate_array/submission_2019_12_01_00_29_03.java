

class Solution {
    public void rotate(int[] nums, int k) {
        helper(nums, 0, k);
    }

    public void helper(int[] nums, int left, int k) {
        int n = nums.length;
        if(left >= n - 1 || k == 0){
            return;
        }
        k %= (n - left);
        int right = n - k;
        for(int i = 0; i < k; i++) {
            int t = nums[left];
            nums[left++] = nums[right];
            nums[right++] = t;
        }
        helper(nums, left, k);
    }
}