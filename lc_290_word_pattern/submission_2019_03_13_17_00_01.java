

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Set<Character> set = new HashSet<>();
        Map<String, Character> m = new HashMap<>();
        
        int n = pattern.length();
        String [] strArray = str.split(" ");
        
        if(n != strArray.length) return false;
        
        for(int i = 0; i < n; i++){
            char c = pattern.charAt(i);
            String s = strArray[i];
            
            if(m.containsKey(s)){
                if(c != m.get(s))
                    return false;
            }
            
            else{
                if(set.contains(c))
                    return false;
                m.put(s, c);
                set.add(c);
            }
        }
        
        return true;
    }
}