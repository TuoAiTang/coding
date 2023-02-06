

class Solution {
    public char findTheDifference(String s, String t) {
        int [] smap = new int[26];
        int [] tmap = new int[26];
        for(int i = 0; i < s.length(); i++){
        	++smap[s.charAt(i) - 'a'];
        	++tmap[t.charAt(i) - 'a'];
        }

        ++tmap[t.charAt(t.length() - 1) - 'a'];

        for(char c = 'a'; c <= 'z'; c++)
        	if(smap[c - 'a'] < tmap[c - 'a'])
        		return c;

        return 'a';		//un-reached
    }
}