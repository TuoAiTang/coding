

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] wm = new int [26];
        int [] pm = new int [26];
        
        List<Integer> res = new ArrayList<>();
        
        for(char c : p.toCharArray())
            pm[c - 'a'] ++;
        
        int window = p.length();
        
        for(int i = 0; i < s.length(); i++){
            wm[s.charAt(i) - 'a'] ++;
            if(i >= window)
                wm[s.charAt(i - window) - 'a']--;
            if(equal(wm, pm))
                res.add(i - window + 1);  
        }
   
        return res;    
    }
    
    boolean equal(int [] a, int [] b){
        for(int i = 0; i < 26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
}