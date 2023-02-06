

class Solution {
    public char findTheDifference(String s, String t) {
        int x = 0;
        for(char c : s.toCharArray())
        	x ^= c - 'a';
        for(char c : t.toCharArray())
        	x ^= c - 'a';
        return (char)('a' + x);	
    }
}