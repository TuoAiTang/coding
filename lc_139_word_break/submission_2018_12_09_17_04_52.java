

class Solution {
     public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> mem = new HashMap<>();
        int n = s.length();
        return wordBreak(s, dict, mem);
    }

    private boolean wordBreak(String s, Set<String> dict, Map<String, Boolean> mem){
    	Boolean b = mem.get(s);
    	if(b != null) return b;
    	if(dict.contains(s)){
    		mem.put(s, true);
    		return true;
    	}
    	for(int j = 1; j < s.length(); j++){
    		String left = s.substring(0, j);
    		String right = s.substring(j);
    		if(dict.contains(right) && wordBreak(left, dict, mem)){
    			mem.put(s, true);
    			return true;
    		}
    	}
    	mem.put(s, false);
    	return false;
    }
}