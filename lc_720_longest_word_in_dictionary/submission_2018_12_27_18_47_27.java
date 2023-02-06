

class Solution {
    public String longestWord(String[] words) {
        Set<String> dict = new HashSet<>();
        for(String w : words)
        	dict.add(w);

        int max_len = 0;
        String ans = "";
        for(String w : words){
        	if(w.length() < max_len) continue;
        	if(w.length() == max_len && w.compareTo(ans) >= 0) continue;
        	StringBuilder sb = new StringBuilder();
        	boolean flag = true;
        	for(int i = 0; i < w.length(); i++){
        		sb.append(w.charAt(i));
        		if(!dict.contains(sb.toString())) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag){
        		max_len = w.length();
        		ans = w;
        	}       	
        }

        return ans;
    }
}