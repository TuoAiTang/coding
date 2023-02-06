

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            int m, n;
            while(l < r){
                m = (l + r) / 2;
                // int n = (m % 2 == 0) ? (m + 1) : (m - 1);
                n = m ^ 1;
                if(nums[m] == nums[n])
                    l = m + 1;
                else
                    r = m;
            }

            return nums[r];	//nums[l] ->the same, since l == r
        }
    }