

class Solution {
    public void rotate(int[] nums, int k) {
        helper(nums, 0, k);
    }

    public void helper(int[] nums, int left, int k) {
        int n = nums.length;
        if(left >= n - 1 || k == 0){
            return;
        }
        if((n - left) < k){
            k %= (n - left);
        }

        int tmp = k;
        int right = n - k;
        while(k-- > 0) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right++;
        }

        helper(nums, left, tmp);
    }
}