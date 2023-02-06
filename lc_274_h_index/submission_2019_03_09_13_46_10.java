

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;
        int [] bucket = new int[n + 1];
        
        for(int c : citations)
            bucket[Math.min(c, n)] ++;
        
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += bucket[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}