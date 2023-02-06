

class Solution {
    public int brokenCalc(int x, int y) {
        if(x == y) return 0;
        if(x > y) return x - y;
        else
            return 1 + brokenCalc(x, y % 2 == 0 ? y / 2 : y + 1);
    }
}