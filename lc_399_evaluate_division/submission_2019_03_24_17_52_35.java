

class Solution {
    class UnionSet{
        Map<String, Pair> parents;
        UnionSet(){parents = new HashMap<>();}
        public void union(String x, String y, double ratio){
            boolean hasX = parents.containsKey(x);
            boolean hasY = parents.containsKey(y);
            if(!hasX && !hasY){
                parents.put(x, new Pair(y, ratio));
                parents.put(y, new Pair(y, 1.0));
            }
            else if(hasX && hasY){
                Pair xx = find(x);
                Pair yy = find(y);
                xx.parent = yy.parent;
                xx.ratio = ratio * yy.ratio / xx.ratio;    
            }
            
            else if(!hasX){
                parents.put(x, new Pair(y, ratio));
            }
            
            else{
                parents.put(y, new Pair(x, 1 / ratio));
            }
        }
        
        public Pair find(String x){
            if(!parents.containsKey(x))
                return null;
            Pair p = parents.get(x);
            if(!p.parent.equals(x)){
                Pair t = find(p.parent);
                p.parent = t.parent;
                p.ratio *= t.ratio;
            }
            return p;
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        UnionSet us = new UnionSet();
        double [] ans = new double [queries.length];
        int idx = 0;
        for(int i = 0; i < values.length; i++)
            us.union(equations[i][0], equations[i][1], values[i]);
        for(String [] que : queries){
            String x = que[0];
            String y = que[1];
            Pair px = us.find(x);
            Pair py = us.find(y);
            if(px == null || py == null || !px.parent.equals(py.parent))
                ans[idx++] = -1.0;
            else
                ans[idx++] = px.ratio / py.ratio;
        }
        return ans;
    }
    
    class Pair{
        String parent;
        double ratio;
        Pair(String p, double r) {parent = p; ratio = r;}
    }
}