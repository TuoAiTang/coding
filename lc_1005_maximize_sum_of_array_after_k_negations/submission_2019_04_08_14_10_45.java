

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int n = A.length;
        int ans = 0;
        while(i < n && K > 0){
            if(A[i] < 0){
                A[i] = - A[i];
                K--;
            }
            else{
                if(K % 2 != 0){
                    if(i > 0 && A[i - 1] < A[i])
                        ans -= 2 * A[i - 1];
                    else
                        A[i] = - A[i];
                }
                K = 0;
            }
            ans += A[i++];
        }
        
        while(i < n)
            ans += A[i++];
        return ans;
    }
}