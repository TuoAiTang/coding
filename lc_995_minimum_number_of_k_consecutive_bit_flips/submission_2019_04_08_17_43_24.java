

class Solution {
    public int minKBitFlips(int[] A, int k) {
        int n = A.length;
        int ans = 0;
        int flip = 0;
        int [] flipped = new int [n];
        for(int i = 0; i < n; i++){
            if(i >= k) flip ^= flipped[i - k];
            if((A[i] ^ flip) == 0){
                if(i + k > n) return -1;
                ans ++;
                flip ^= 1;
                flipped[i] = 1;
            }
        }    
        return ans;
    }
}