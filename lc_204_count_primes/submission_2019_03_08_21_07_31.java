

class Solution {
    public int countPrimes(int n) {
        boolean [] pm = new boolean [n];
        for(int i = 2; i < n; i ++)
            pm[i] = true;
        for(int i = 2; i * i < n; i++){
            if(pm[i]){
                for(long j = i * i; j < n; j += i)
                    pm[(int)j] = false;
            }
        }
        int ans = 0;
        for(boolean b : pm)
            ans += b ? 1 : 0;
        return ans;
    }
}