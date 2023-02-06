

class Solution {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int mod = (int) 1e9 + 7;
        long ans = 0;
        long p = 1;
        for(int i = 0; i < A.length; i++){
        	ans = (ans + (A[i] - A[A.length - i - 1]) * p) % mod;
            p = (p << 1) % mod;
        }
        return (int) (ans + mod) % mod;
    }
}