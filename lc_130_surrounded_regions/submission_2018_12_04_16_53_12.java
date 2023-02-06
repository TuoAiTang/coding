

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;

        //top/bottom boader
        for(int i = 0; i < n; i++){
        	if(board[0][i] == 'O')
        		dfs(0, i, board, m, n);
        	if(board[m - 1][i] == 'O')
        		dfs(m - 1, i, board, m, n);
        }

        //left/right boader
        for(int i = 0; i < m; i++){
        	if(board[i][0] == 'O')
        		dfs(i, 0, board, m, n);
        	if(board[i][n - 1] == 'O')
        		dfs(i, n - 1, board, m, n);
        }

        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		board[i][j] = (board[i][j] == '.') ? 'O' : 'X';
    }

    private void dfs(int x, int y, char [][] board, int m, int n){
    	if(x < 0 || y < 0 || x >= m || y >= n || board[x][y] == 'X' || board[x][y] == '.')
    		return;
    	board[x][y] = '.';
    	int [] dirs = {-1, 0, 1, 0, -1};	
    	for(int i = 0; i < 4; i++){
    		int nx = x + dirs[i];
    		int ny = y + dirs[i + 1];
    		dfs(nx, ny, board, m, n);
    	}
    }
}