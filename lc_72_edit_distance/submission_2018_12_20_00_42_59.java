

class Solution {
    private int [][] dp;

	public int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		dp = new int[l1 + 1][l2 + 1];
		for(int [] d : dp)
			Arrays.fill(d, -1);
		return minDistance(word1, l1, word2, l2);
        
    }

    private int minDistance(String word1, int l1, String word2, int l2){
    	if(l1 == 0) return l2;
        if(l2 == 0) return l1;
        if(dp[l1][l2] != -1) return dp[l1][l2];
        int ans = 0;
        if(word1.charAt(l1 - 1) == word2.charAt(l2 - 1))
        	ans = minDistance(word1, l1 - 1, word2, l2 - 1);

        else ans = Math.min(Math.min(minDistance(word1, l1 - 1, word2, l2),
        						 minDistance(word1, l1, word2, l2 - 1)),
        				minDistance(word1, l1 - 1, word2, l2 - 1)) + 1;
        dp[l1][l2] = ans;
    	return ans;
    }
}