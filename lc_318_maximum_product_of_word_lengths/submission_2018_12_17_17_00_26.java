

class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int ans = 0;
        for(int i = 0; i < words.length; i++){
        	for(int j = i; j < words.length; j++){
        		if(!hasCommon(words[i], words[j])){
        			ans = Math.max(ans, words[i].length() * words[j].length());
        			break;
        		}
        	}
        }
        return ans;
    }

    private boolean hasCommon(String a, String b){
    	if(a.length() == 0 || b.length() == 0) return false;
    	char [] map = new char[26];
    	for(char c : a.toCharArray())
    		++map[c - 'a'];
    	for(char c : b.toCharArray())
    		if(map[c - 'a'] != 0)
    			return true;
		return false;
    }
}