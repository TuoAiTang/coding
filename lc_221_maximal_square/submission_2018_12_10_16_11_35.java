

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        //pre-process by dp
        int [][] sums = new int [m + 1][n + 1];
        for(int i = 1; i <= m; i++)
        	for(int j = 1; j <= n; j++){
        		sums[i][j] = matrix[i - 1][j - 1] - '0'
        				   + sums[i - 1][j]
        				   + sums[i][j - 1]
        				   - sums[i - 1][j - 1];	
        	}

       	int ans = 0;
       	for(int i = 1; i <= m; i++)
       		for(int j = 1; j <= n; j++)
       			for(int size = Math.min(m - i + 1, n - j + 1); size > 0; size--){
       				int sum = sums[i + size - 1][j + size - 1]
       						- sums[i + size - 1][j - 1]
       						- sums[i - 1][j + size - 1]
       						+ sums[i - 1][j - 1];

					if(sum == size * size){
						ans = Math.max(ans, sum);
						break;
       				}
				}

		return ans;
    }
}