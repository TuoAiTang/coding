

class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl != tl) return false;
        int [] m = new int [26];
        
        for(int i = 0; i < sl; i++)
            m[s.charAt(i) - 'a'] ++;
        
        for(int i = 0; i < sl; i++)
            m[t.charAt(i) - 'a'] --;

        
        for(int i = 0; i < 25; i ++)
            if(m[i] != 0)
                return false;
        return true;
    }
}