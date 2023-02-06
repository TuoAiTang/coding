

class Solution {
    public int nthUglyNumber(int n) {
        int [] li = new int [n];
        int i = 0;
        li[i++] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next2, next3, next5;
        int next;
        while(i < n){
            next2 = li[i2] * 2;
            next3 = li[i3] * 3;
            next5 = li[i5] * 5;
            
            next = Math.min(next2, Math.min(next3, next5));
            
            i2 += (next == next2 ? 1 : 0);
            i3 += (next == next3 ? 1 : 0);
            i5 += (next == next5 ? 1 : 0);
            
            li[i++] = next;
        }
        
        return li[n - 1];
    }
}