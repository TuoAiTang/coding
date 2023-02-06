

class Solution {
    public int numJewelsInStones(String J, String S) {
        int [] set = new int[255];
        for(char c : J.toCharArray())
            set[c] = 1;
        
        int ans = 0;
        for(char c : S.toCharArray())
            if(set[c] == 1)
                ans ++;
        
        return ans;
    }
}