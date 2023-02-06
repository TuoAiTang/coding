

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        //c[i] -> the number of LIS ends with nums[i]
        //l[i] -> the max length of LIS ends with nums[i]
        int [] c = new int [n];
        Arrays.fill(c, 1);
        int [] l = new int [n];
        Arrays.fill(l, 1);

        for(int i = 0; i < n; i++)
        	for(int j = 0; j < i; j++){
        		if(nums[i] > nums[j]){
        			if(l[j] + 1 > l[i]){
        				l[i] = l[j] + 1;
        				c[i] = c[j];
        			}
        			else if(l[j] + 1 == l[i]){
        				c[i] += c[j];
        			}
        		}
        	}

        int max_len = 1;
        for(int len : l)
        	max_len = Math.max(max_len, len);

        int ans = 0;
        for(int i = 0; i < n; i++)
        	if(l[i] == max_len)
        		ans += c[i];
        return ans;
    }
}