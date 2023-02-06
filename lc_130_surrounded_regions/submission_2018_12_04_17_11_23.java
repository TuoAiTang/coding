

class Solution {
    class Point{
    	int x, y;
    	Point(int x_, int y_) {x = x_; y = y_;}
    }
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;

        Queue<Point> q = new LinkedList<>();

        //top/bottom boader
        for(int i = 0; i < n; i++){
        	if(board[0][i] == 'O')
        		q.add(new Point(0, i));
        	if(board[m - 1][i] == 'O')
        		q.add(new Point(m - 1, i));
        }

        //left/right boader
        for(int i = 0; i < m; i++){
        	if(board[i][0] == 'O')
        		q.add(new Point(i, 0));
        	if(board[i][n - 1] == 'O')
        		q.add(new Point(i, n - 1));
        }

        int [] dirs = {-1, 0, 1, 0, -1};
        while(!q.isEmpty()){
        	int size = q.size();
        	while(size-- > 0){
        		Point p = q.remove();
        		int x = p.x;
        		int y = p.y;
        		if(board[x][y] == 'O')
        			board[x][y] = '.';
        		for(int i = 0; i < 4; i ++){
        			int nx = x + dirs[i];
        			int ny = y + dirs[i + 1];
        			if(nx < 0 || ny < 0 || nx >= m || ny >= n || board[nx][ny] != 'O')
        				continue;
        			q.add(new Point(nx, ny));
        		}
        	}
        }

        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		board[i][j] = (board[i][j] == '.') ? 'O' : 'X';
    }
}