

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int ans = 0;
        int point= 0;
        while(i <= j){
            if(P >= tokens[i]){
                P -= tokens[i++];
                ans = Math.max(ans, ++point);
            }
            else if(point > 0){
                P += tokens[j--];
                point--;
            }
            else
                break;
        }
        return ans;
    }
}