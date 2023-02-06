

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String [] words = str.split(" ");
        int n = words.length;
        if(n != pattern.length()) return false;

        for(int i = 0; i < n; i++){

        	char c = pattern.charAt(i);
        	String s = words[i];

        	if(map.containsKey(c)){
        		if(!map.get(c).equals(s))
        			return false;
        	}
        	else {
        		if(set.contains(s)) return false;
        		set.add(s);
        		map.put(c, s);
        	}
        }

        return true; 
    }
}