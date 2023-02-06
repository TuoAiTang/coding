

class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char [] s = S.toCharArray();
        int c = 0;
        for(int i = shifts.length - 1; i >= 0; i--){
        	c += shifts[i] % 26;
        	s[i] = (char) ('a' + (s[i] - 'a' + c) % 26);
        }
        return String.valueOf(s);
    }
}