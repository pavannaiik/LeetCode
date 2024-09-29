class Trie {
    TrieNode root = new TrieNode();
    public Trie() {
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c-'a';
            if(node.children[index]==null){
                node.children[index]= new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            node = node.children[c-'a'];
            if(node==null){
                return false;
            }
        }
        return  node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            node = node.children[c-'a'];
            if(node==null){
                return false;
            }
        }
        return true;
    }
}
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */