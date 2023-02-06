

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        //the ans must be 3 consecutive elements
        for(int i = n - 1; i >= 2; i--)
            if(A[i] < A[i - 1] + A[i - 2])
                return A[i] + A[i - 1] + A[i - 2];
        return 0;
    }
}