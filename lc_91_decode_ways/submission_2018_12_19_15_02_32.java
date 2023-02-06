

class Solution {
    private Map<String, Integer> memo;
    public int numDecodings(String s) {
    	if(s == null) return 0;
        memo = new HashMap<>();
        return ways(s);
    }

    private int ways(String s){
    	if(s.equals("")) return 1;
    	if(s.startsWith("0")) return 0;
        if(s.length() == 1) return 1;
    	if(memo.containsKey(s)) return memo.get(s);

    	int w = ways(s.substring(1));
    	int prefix = Integer.valueOf(s.substring(0, 2));
    	if(prefix >= 10 && prefix <= 26)
    		w += ways(s.substring(2));
    	memo.put(s, w);
    	return w;
    }
}