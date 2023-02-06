

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int [] set = new int [nums.length];
        dfs(ans, cur, nums.length, set, nums);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> cur, int n, int [] set, int [] nums){
        if(cur.size() == n){
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(set[i] == 1) continue;
            cur.add(nums[i]);
            set[i] = 1;
            dfs(ans, cur, n, set, nums);
            cur.remove(cur.size() - 1);
            set[i] = 0;
        }
    }
}