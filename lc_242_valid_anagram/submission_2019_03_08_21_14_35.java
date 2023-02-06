

class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl != tl) return false;
        int [] sm = new int [26];
        int [] tm = new int [26];
        for(int i = 0; i < sl; i++){
            sm[s.charAt(i) - 'a'] ++;
            tm[t.charAt(i) - 'a'] ++;
        }
        
        for(int i = 0; i < 25; i ++)
            if(sm[i] != tm[i])
                return false;
        return true;
    }
}