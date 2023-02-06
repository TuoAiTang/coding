

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = find(word);
        return p != null && p.is_word;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = find(prefix);
        return p != null;
    }

    private TrieNode find(String prefix){
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(p.children[index] == null) return null;
            p = p.children[index];
        }
        return p;
    }

    public class TrieNode{
        public boolean is_word;
        public TrieNode [] children;
        TrieNode(){is_word = false; children = new TrieNode[26];}
    }
        
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */