

class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        
        int n = secret.length();
        
        int [] m = new int [10];
        
        
        for(int i = 0; i < n; i++){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g == s)
                bull++;
            else{
                if(m[s - '0'] ++ < 0) cow++;
                if(m[g - '0'] -- > 0) cow++;
            } 
        }
        
        
        return bull + "A" + cow + "B";
    }
}