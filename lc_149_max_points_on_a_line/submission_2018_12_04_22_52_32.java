

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    class SlopeKey{
		int nr;	//numerator
		int dr;	//denominator
		SlopeKey(int nr, int dr) {this.nr = nr; this.dr = dr;}

        @Override
        public int hashCode(){
            // return (nr << 16) + (dr << 8); //20ms
            // return nr + dr; //14ms
            return nr;
        }

        @Override
        public boolean equals(Object o){
            if(!(o instanceof SlopeKey)) return false;
            SlopeKey sk = (SlopeKey) o;
            return this.nr == sk.nr && this.dr == sk.dr;
        }

	}
	private SlopeKey getSlopeKey(Point p1, Point p2){
		int dx = p1.x - p2.x;
		int dy = p1.y - p2.y;
        //vertical line
		if(dx == 0) return new SlopeKey(p1.x, 0);
        //horizontal line
		if(dy == 0) return new SlopeKey(0, p1.y);
		int divisor = gcd(dx, dy);
		return new SlopeKey(dy / divisor, dx / divisor);	//the simplest slope
	}
	private int gcd(int m, int n){
		if(n == 0) return m;
		return gcd(n, m % n);
	}
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n < 2) return n;
        int ans = 1;
        for(int i = 0; i < n; i++){
        	Point p1 = points[i];
        	int samePoints = 0;
        	int maxPoints = 1;
        	Map<SlopeKey, Integer> map = new HashMap<>();	//(slopekey, count)
        	for(int j = i + 1; j < n; j++){
        		Point p2 = points[j];
        		if(p1.x == p2.x && p1.y == p2.y){
        			samePoints++;
        			continue;
        		}
        		SlopeKey sk = getSlopeKey(p1, p2);
        		map.put(sk, map.getOrDefault(sk, 1) + 1);
        		maxPoints = Math.max(maxPoints, map.get(sk));
    		}
    		ans = Math.max(ans, samePoints + maxPoints);
        }
        return ans;
    }
}