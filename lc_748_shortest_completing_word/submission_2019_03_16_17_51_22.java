

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int [] map = new int [26];
        fillmap(map, licensePlate);
        int min_len = Integer.MAX_VALUE;
        String ans = "";
        for(String word : words){
            if(word.length() >= min_len) continue;
            
            int [] smap = new int [26];
            fillmap(smap, word);
            
            if(valid(map, smap)){
                ans = word;
                min_len = ans.length();
            } 
        }
        return ans;
    }
    
    public boolean valid(int [] a, int [] b){
        for(int i = 0; i < 26; i++){
            if(b[i] < a[i])
                return false;
        }
        return true;
    }
    
    public void fillmap(int [] a, String s){
        String ls = s.toLowerCase();
        int l = ls.length();
        
        for(int i = 0; i < l; i++){
            int c = ls.charAt(i) - 'a';
            if(c >= 0 && c < 25)
                a[c]++;
        }
    }
}