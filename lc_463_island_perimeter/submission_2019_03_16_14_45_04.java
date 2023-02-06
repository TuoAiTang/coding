

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int area = 0;
        int conn = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    area++;
                    if(i > 0 && grid[i - 1][j] == 1) conn++;
                    if(j > 0 && grid[i][j - 1] == 1) conn++;
                }
            }
        }
        
        return area * 4 - conn * 2;
    }
}