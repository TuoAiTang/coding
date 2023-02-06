

class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        for(int num : nums){
            l = Math.max(l, num);
            r += num;
        }
        int mid;
        int res;
        res = -1;
        while(l <= r){
            mid = (int) ((l + r) / 2);
            if(groups(nums, mid) > m)
                l = mid + 1;
            else{
                r = mid - 1;
                res = mid;
            }
        }
        return res;
    }
    
    public int groups(int [] nums, int c){
        int k = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num > c){
                sum = num;
                k++;
            }
            else
                sum += num;
        }
        return k;
    }   
}