

class Solution {
    public String getHint(String secret, String guess) {
        int [] smap = new int [10];
        int [] gmap = new int [10];
        int n = secret.length();
        int A = 0;
        int B = 0;

        for(int i = 0; i < n; i++){
            if(secret.charAt(i) == guess.charAt(i))
                A++;
            else{
                smap[secret.charAt(i) - '0']++;
                gmap[guess.charAt(i) - '0']++;
            }
        }

        for(int i = 0; i <= 9; i++){
            B += Math.min(smap[i], gmap[i]);
        }
        
        return A + "A" + B + "B";
    }
}