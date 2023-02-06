

class Solution {
    class Trie{
        private TrieNode root;
        Trie() {root = new TrieNode();}
        
        public void insert(String word){
            TrieNode p = root;
            for(int i = 0; i < word.length(); i++){
                int c = word.charAt(i) - 'a';
                if(p.children[c] == null)
                    p.children[c] = new TrieNode();
                p = p.children[c];
            }
            p.is_word = true;
        }
        
        public boolean hasAllPrefixes(String word){
            TrieNode p = root;
            for(int i = 0; i < word.length(); i++){
                int c = word.charAt(i) - 'a';
                if(p.children[c] == null || !p.children[c].is_word)
                    return false;
                p = p.children[c];
            }
            return true;
        }
        
        class TrieNode{
            boolean is_word;
            TrieNode [] children;
            
            TrieNode(){
                is_word = false;
                children = new TrieNode [26];
            }
        }
    }
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for(String w : words)
            t.insert(w);
        
        int max_len = 0;
        String ans = "";
        
        for(String w : words){
            if(w.length() < max_len) continue;
            if(w.length() == max_len && w.compareTo(ans) >= 0) continue;
            if(t.hasAllPrefixes(w)){
                max_len = w.length();
                ans = w;
            }
        }
        return ans;
    }
}