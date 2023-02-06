

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [][] pre = prerequisites;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int [] e : pre){
            if(!g.containsKey(e[0]))
                g.put(e[0], new ArrayList<>());
            g.get(e[0]).add(e[1]);
        }
        
        int [] visited = new int [numCourses];
        for(int u : g.keySet())
            if(hasCycle(g, u, visited))
                    return false;
        return true;
    }
    
    public boolean hasCycle(Map<Integer, List<Integer>> g, int u, int [] visited){
        if(!g.containsKey(u)) return false;
        visited[u] = 1;
        for(int v : g.get(u))
            if(visited[v] == 1 || hasCycle(g, v, visited))
                return true;
        visited[u] = 0;
        return false;
    }
}