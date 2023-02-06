

class Solution {
    public String longestWord(String[] words) {
        Set<String> s = new HashSet<>();
        for(String word : words)
            s.add(word);
        int ml = 0;
        String mw = "";
        for(String w : words){
            if(w.length() < ml) continue;
            if(w.length() == ml && w.compareTo(mw) >= 0) continue;
            int n = w.length();
            boolean flag = true;
            for(int i = 1; i < n; i++){
                if(!s.contains(w.substring(0, i))){
                    flag = false;
                    break;
                }   
            }
            if(flag){
                ml = w.length();
                mw = w;
            }    
        }
        
        return mw;
    }
}