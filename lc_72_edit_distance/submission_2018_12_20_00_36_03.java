

class Solution {
    private Map<String, Integer> memo;

	public int minDistance(String word1, String word2) {
		memo = new HashMap<>();
		int l1 = word1.length();
		int l2 = word2.length();
		return minDistance(word1, l1, word2, l2);
        
    }

    private int minDistance(String word1, int l1, String word2, int l2){
    	if(l1 == 0) return l2;
        if(l2 == 0) return l1;
        String key = l1 + "," + l2;
        if(memo.containsKey(key))
        	return memo.get(key);
        int ans = 0;
        if(word1.charAt(l1 - 1) == word2.charAt(l2 - 1))
        	ans = minDistance(word1, l1 - 1, word2, l2 - 1);

        else ans = Math.min(Math.min(minDistance(word1, l1 - 1, word2, l2),
        						 minDistance(word1, l1, word2, l2 - 1)),
        				minDistance(word1, l1 - 1, word2, l2 - 1)) + 1;
        memo.put(key, ans);
    	return ans;
    }
}