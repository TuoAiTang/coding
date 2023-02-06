

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        //nums[a] <= nums[b] <= nums[c]
        for(int c = n - 1; c > 1; c--){
        	int b = c - 1;
        	int a = 0;
        	while(a < b){
        		if(nums[a] + nums[b] > nums[c]){
        			ans += b - a;
        			--b;
        		}else{
        			a++;
        		}
        	}
        }
        return ans;
    }
}