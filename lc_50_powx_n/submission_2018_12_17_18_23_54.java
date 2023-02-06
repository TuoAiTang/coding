

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double d = myPow(x, n / 2);
        if(n % 2 == 0) return d * d;
        if(n < 0) return d * d / x;
        return d * d * x;
    }
}