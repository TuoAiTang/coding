

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [][] pre = prerequisites;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int [] e : pre){
            if(!g.containsKey(e[1]))
                g.put(e[1], new ArrayList<>());
            g.get(e[1]).add(e[0]);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int [] visit = new int [numCourses];
        for(int i = 0; i < numCourses; i++)
            if(hasCycle(g, i, visit, ans))
                    return new int [0];
        
        int [] res = new int [numCourses];
        int index = 0;
        for(int i = ans.size() - 1; i >= 0; i--)
            res[index++] = ans.get(i);
        
        return res;
    }
    
    public boolean hasCycle(Map<Integer, List<Integer>> g, int u, int [] visit, List<Integer> ans){
        if(visit[u] == 1) return true;
        if(visit[u] == 2) return false;
        
        visit[u] = 1;
        
        if(!g.containsKey(u)) {
            visit[u] = 2;
            ans.add(u);
            return false;
        }
        
        for(int v : g.get(u))
            if(hasCycle(g, v, visit, ans))
                return true;
        
        visit[u] = 2;
        ans.add(u);
        return false;
    }
}