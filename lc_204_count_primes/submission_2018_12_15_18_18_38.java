

class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
    	//p[i] == 0 -> not prime
    	//p[i] == 1 -> prime
        int [] p = new int[n];
        Arrays.fill(p, 1);
        p[0] = p[1] = 0;
        for(int i = 2; i <= Math.sqrt(n); i++){
        	if(p[i] == 0) continue;
        	for(long j = i * i; j < n; j += i)
        		p[(int)j] = 0;
        }

        int ans = 0;
        for(int x : p)
        	ans += x;
        return ans;
    }
}