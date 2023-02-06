

class Solution {
    public int minKBitFlips(int[] A, int k) {
        int n = A.length;
        int ans = 0;
        for(int i = 0; i < n; i++)
            if(A[i] == 0){
                if(i + k > n) return -1;
                for(int j = 0; j < k; j++)
                    A[i + j] ^= 1;
                ans++;
            }
        return ans;
    }
}