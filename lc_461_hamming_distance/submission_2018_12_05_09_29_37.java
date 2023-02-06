

class Solution {
    public int hammingDistance(int x, int y) {
        int d = x ^ y;
        int ans = 0;
        while(d > 0){
            ans += (d & 1);
            d >>= 1;
        }
        return ans;
    }
}