

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
                int cur_color = colors[cur];
                for(int nbr : graph[cur]){
                    if(colors[nbr] == cur_color) return false;
                    if(colors[nbr] != 0) continue;
                    q.offer(nbr);
                    colors[nbr] = -cur_color;
                }
            }
        }          
        return true;
    }

}