

class Solution {
    public int searchInsert(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] > target)
                r = mid - 1;
            else if(nums[mid] < target)
                l = mid + 1;
            else
                return mid;
        }
        
        return l;
    }
}