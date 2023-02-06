

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        
        int n = pattern.length();
        String [] strArray = str.split(" ");
        
        if(n != strArray.length) return false;
        
        for(int i = 0; i < n; i++){
            char c = pattern.charAt(i);
            String s = strArray[i];
            
            if(m2.containsKey(s)){
                char c1 = m2.get(s);
                if(c1 != c)
                    return false;
            }
            
            else{
                if(m1.containsKey(c))
                    return false;
                m2.put(s, c);
                m1.put(c, s);
            }
        }
        
        return true;
    }
}