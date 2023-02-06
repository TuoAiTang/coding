

class Solution {
    private static int next2, next3, next5;
    private static int next;
    private int [] uglyList;
    private int i = 0;
    private int i2 = 0, i3 = 0, i5 = 0;
    public int nthUglyNumber(int n) {
        uglyList = new int[n];       
        uglyList[i++] = 1;
        while(i < n){
            next2 = uglyList[i2] * 2;
            next3 = uglyList[i3] * 3;
            next5 = uglyList[i5] * 5;
            next = Math.min(next2, Math.min(next3, next5));
            if(next == next2)
                i2++;
            if(next == next3)
                i3++;
            if(next == next5)
                i5++;
            uglyList[i++] = next;
        }
        return uglyList[n - 1];
    }
}