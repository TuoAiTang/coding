

class Solution {
    int count;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int [] open = new int [rooms.size()];
        dfs(rooms, 0, open);
        return count == rooms.size();
    }
    
    public void dfs(List<List<Integer>> rooms, int cur, int [] open){
        open[cur] = 1;
        count++;
        for(int nbr : rooms.get(cur)){
            if(open[nbr] == 1) continue;
            dfs(rooms, nbr, open);
        }
    }
}