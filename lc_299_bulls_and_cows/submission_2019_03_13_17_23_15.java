

class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        
        int n = secret.length();
        
        int [] sm = new int [10];
        int [] gm = new int [10];
        
        
        for(int i = 0; i < n; i++){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g == s)
                bull++;
            else{
                sm[s - '0']++;
                gm[g - '0']++;
            } 
        }
        
        for(int i = 0; i < 10; i++)
            cow += Math.min(sm[i], gm[i]);
        
        return bull + "A" + cow + "B";
    }
}