

class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int m;
        while(l <= r){
        	m = (l + r) / 2;
        	if(m > x / m)
        		r = m - 1;
        	else
        		l = m + 1;
        }
        return r;
    }
}