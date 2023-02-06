

class Solution {
    private Map<String, Integer> memo = new HashMap<>();

	public int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
        if(l1 == 0) return l2;
        if(l2 == 0) return l1;
        String key = l1 + "," + l2;
        if(memo.containsKey(key))
        	return memo.get(key);
        int ans = 0;
        String s1 = word1.substring(0, l1 - 1);
        String s2 = word2.substring(0, l2 - 1);
        if(word1.charAt(l1 - 1) == word2.charAt(l2 - 1))
        	ans = minDistance(s1, s2);

        else ans = Math.min(Math.min(minDistance(s1, word2),
        						 minDistance(word1, s2)),
        				minDistance(s1, s2)) + 1;
        memo.put(key, ans);
    	return ans;
    }
}