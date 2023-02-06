

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(k, 1, ans, cur, n);
        return ans;
    }
    
    public void dfs(int k, int s, List<List<Integer>> ans, List<Integer> cur, int n){
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return ;
        }
        for(int i = s; i <= n; i++){
            cur.add(i);
            dfs(k, i + 1, ans, cur, n);
            cur.remove(cur.size() - 1);
        }
    }
}