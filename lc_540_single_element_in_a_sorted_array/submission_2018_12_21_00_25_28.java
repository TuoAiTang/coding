

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int m = (l + r) / 2;
                int n = (m % 2 == 0) ? (m + 1) : (m - 1);

                if(nums[m] == nums[n])
                    l = m + 1;
                else
                    r = m;
            }

            return nums[l];
        }
    }