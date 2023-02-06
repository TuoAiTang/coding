

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        //build graph
        Map<String, Map<String, Double>> g = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            String [] s = equations[i];
            String a = s[0], b = s[1];
            double ratio = values[i];
            if(!g.containsKey(a))
                g.put(a, new HashMap<>());
            if(!g.containsKey(b))
                g.put(b, new HashMap<>());
            g.get(a).put(b, ratio);
            g.get(b).put(a, 1 / ratio);
        }
        
        double [] ans = new double [queries.length]; 
        int i = 0;
        for(String [] que : queries){
            String a = que[0];
            String b = que[1];
            if(!g.containsKey(a) || !g.containsKey(b))
                ans[i++] = -1.0;
            else
                ans[i++] = dfs(a, b, g, new HashSet<>());
        }
        
        return ans;
    }
    
    public double dfs(String a, String b, Map<String, Map<String, Double>> g, Set<String> visited){
        if(a.equals(b)) return 1.0;
        visited.add(a);
        for(String s : g.get(a).keySet()){
            if(visited.contains(s)) continue;
            double tmp = dfs(s, b, g, visited);
            if(tmp > 0)
                return g.get(a).get(s) * tmp;
        }       
        return -1.0;
    }
    
}