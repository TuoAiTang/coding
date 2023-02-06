

class Solution {
    public boolean judgeSquareSum(int c) {
        int m = (int) Math.sqrt(c);
        for(int a = 0; a <= m; a++){
        	//estimate b by a
        	int b = (int) Math.round(Math.sqrt(c - a * a));
        	if(a * a + b * b == c) return true;
        }
        return false;
    }
}