

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0, j = 0;
        int n = s.length();
        
        HashSet<Character> hs = new HashSet<>();
        
        while(i < n && j < n){
            if(hs.contains(s.charAt(j)))
                hs.remove(s.charAt(i++));

            else{
                hs.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
        }
        
        return ans;
    }
}