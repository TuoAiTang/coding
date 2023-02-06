

class Solution {
    class Trie {

    //Space: O(26 * n * l)
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    //Time: O(l)
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null)
                p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.is_word = true;
    }

    /*specific operations for some problems (e.g. 720)*/
    public boolean hasAllPrefixes(String word){
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null) return false;
            p = p.children[index];
            if(!p.is_word) return false;
        }
        return true;
    }

    public class TrieNode{
        public boolean is_word;
        public TrieNode [] children;
        TrieNode(){is_word = false; children = new TrieNode[26];}
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