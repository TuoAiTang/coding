

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int [][] sizes = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++){
        		sizes[i][j] = matrix[i][j] - '0';
        		if(matrix[i][j] == '0') continue;
        		if(i != 0 && j != 0)
        		    sizes[i][j] = Math.min(Math.min(sizes[i - 1][j], sizes[i][j - 1])
        								, sizes[i - 1][j - 1]) + 1;
        		ans = Math.max(ans, sizes[i][j] * sizes[i][j]);
        	}
        return ans;
    }
}