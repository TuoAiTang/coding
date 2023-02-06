

class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = nums.length;
        for(int i = 0; i < ans; i++){
        	if(nums[i] == val){
        		for(int j = i; j < ans - 1; j++){
        			nums[j] = nums[j + 1];        			               
        		}
                ans--;
                i--;
        	}
    	}
    	return ans;
    }
}