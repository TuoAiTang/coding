

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++)
        	dfs(i, 0, ans, cur, nums);
        return ans;
    }

    private void dfs(int n, int s, List<List<Integer>> ans, List<Integer> cur, int [] nums){
    	if(cur.size() == n){
    		ans.add(new ArrayList<>(cur));
    		return;
    	}
    	for(int i = s; i < nums.length; i++){
    		cur.add(nums[i]);
    		dfs(n, i + 1, ans, cur, nums);
    		cur.remove(cur.size() - 1);
    	}   	
    }
}