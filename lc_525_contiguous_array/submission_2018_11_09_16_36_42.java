

class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
		int n = nums.length;
		if(n < 2)
			return ans;
        for (int i = 0; i < n; i++) {
			if(nums[i] == 0)
				nums[i] = -1;
		}
        int []sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++) {
        	sum[i] = sum[i - 1] + nums[i];
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	if(sum[i] == 0)
        		ans = i + 1;
        	else {
        		if(!hm.containsKey(sum[i]))
    				hm.put(sum[i], i);
        		else
					ans = Math.max(ans, i - hm.get(sum[i]));
        	}		
		}       
        return ans; 
    }
}