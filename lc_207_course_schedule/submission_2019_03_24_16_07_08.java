

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [][] pre = prerequisites;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int [] e : pre){
            if(!g.containsKey(e[0]))
                g.put(e[0], new ArrayList<>());
            g.get(e[0]).add(e[1]);
        }
        
        int [] visit = new int [numCourses];
        for(int u : g.keySet())
            if(hasCycle(g, u, visit))
                    return false;
        return true;
    }
    
    public boolean hasCycle(Map<Integer, List<Integer>> g, int u, int [] visit){
        if(visit[u] == 1) return true;
        if(visit[u] == 2) return false;
        
        visit[u] = 1;
        
        if(!g.containsKey(u)) {
            visit[u] = 2;
            return false;
        }
        
        for(int v : g.get(u))
            if(hasCycle(g, v, visit))
                return true;
        
        visit[u] = 2;
        return false;
    }
}