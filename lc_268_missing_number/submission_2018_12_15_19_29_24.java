

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tmp;
        for(int i = 0; i < n; i++){
            //place all element with value n into the nth position(based 0)
            while(nums[i] < n && nums[nums[i]] != nums[i]){
                tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        for(int i = 0; i < n; i++)
            if(nums[i] != i)
                return i;
        return n; 
    }
}