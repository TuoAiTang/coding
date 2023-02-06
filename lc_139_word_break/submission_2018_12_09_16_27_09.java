

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean [] dp = new boolean[n + 1];
        //dp[i] -> the index from 1 to i sub-problems
        //i -> [1, n]
        //wordBreak(s.substring(0, i))
        dp[0] = true;

        //i -> the length of sub-problems
        for(int i = 1; i <= n; i++){
        	for(int j = 0; j < i; j++){
        		if(dp[j]){
        			String new_s = s.substring(j, i);
        			if(dict.contains(new_s)){
        				dp[i] = true;
        				break;
        			}
        		}
        	}
        }
        return dp[n];
    }
}