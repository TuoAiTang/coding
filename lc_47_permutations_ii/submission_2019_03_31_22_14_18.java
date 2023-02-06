

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 0, nums);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, int index, int [] nums){
        int n = nums.length;
        if(index == n){
            List<Integer> res = new ArrayList<>();
            ans.add(res);
            for(int num : nums)
                res.add(num);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, index, i);
            dfs(ans, index + 1, nums);
            swap(nums, index, i);
        }
    }
    
    public void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}