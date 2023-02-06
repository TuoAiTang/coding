

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
    
    public int gcd(int m, int n){
        if(n == 0) return m;
        return gcd(n, m % n);
    }
    
    public long getSlope(int y, int x){
        if(y == 0) return 0L;   //horizontal
        if(x == 0) return (long) (1 << 32); //vertical
        int gcd = gcd(y, x);
        
        return (long) (y / gcd) << 32 | (x / gcd);
    }
    
    
    public int maxPoints(Point[] points) {
        int ans = 0;
        
        for(int i = 0; i < points.length; i++){
            int x = points[i].x;
            int y = points[i].y;
            int maxPoint = 0;
            int samePoint = 0;
            HashMap<Long, Integer> hm = new HashMap<>();
            for(int j = i; j < points.length; j++){
                if(points[j].x == x && points[j].y == y)
                    samePoint ++;
                else{
                    long slope = getSlope(points[j].y - y, points[j].x - x);
                    hm.put(slope, hm.getOrDefault(slope, 0) + 1);
                    maxPoint = Math.max(maxPoint, hm.get(slope));
                }  
            }
            ans = Math.max(ans, samePoint + maxPoint);
        }  
        
        return ans;
    }
}