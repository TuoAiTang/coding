

class Solution {
    public void sortColors(int[] nums) {
        int smaller = 0, cur = 0, larger = nums.length - 1;
        int pivot = 1;
        while(cur <= larger){
            int num = nums[cur];
            
            if(num == pivot)
                cur++;
            
            else if(num > pivot)
                swap(nums, cur, larger--);
            
            else
                swap(nums, cur++, smaller++);
        }
    }
    
    public void swap(int [] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}