

class Solution {
    public boolean isBipartite(int[][] graph) {  
        int [] colors = new int [graph.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(colors[i] != 0) continue;
            colors[i] = 1;
            q.offer(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int nbr : graph[cur]){
                    if(colors[nbr] == colors[cur]) return false;
                    if(colors[nbr] != 0) continue;
                    q.offer(nbr);
                    colors[nbr] = (colors[cur] == 1 ? 2 : 1);
                }
            }
        }
            
        return true;
    }
    
   
}