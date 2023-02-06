

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
    	//sparse graph -> construct by adjacency table
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < N; i++)
        	g.add(new ArrayList<>());
        for(int [] d : dislikes){
        	g.get(d[0] - 1).add(d[1] - 1);
        	g.get(d[1] - 1).add(d[0] - 1);
        }

        int [] colors = new int[N]; //0 -> unknown; 1 -> red; -1 -> blue;

        for(int i = 0; i < N; i++){
        	if(colors[i] == 0){
        		colors[i] = 1;
        		if(!dfs(i, colors, g)) 
        			return false;
        	}
        }
        return true;
    }

    private boolean dfs(int cur, int [] colors, List<List<Integer>> g){
    	for(int next : g.get(cur)){
    		if(colors[next] == colors[cur]) return false;
    		if(colors[next] == -colors[cur]) continue;
    		colors[next] = -colors[cur];
    		if(!dfs(next, colors, g))
    			return false;
    	}
    	return true;
    }
}