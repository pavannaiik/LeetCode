class Trie {
    TrieNode root ;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curNode = root;
        for(char ch:word.toCharArray()){
            if(curNode.children[ch-'a']==null){
                curNode.children[ch-'a'] = new TrieNode();
            }
            curNode = curNode.children[ch-'a'];
        }
        curNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curNode = root;
        for(char ch:word.toCharArray()){
            if(curNode.children[ch-'a']==null) return false;
            curNode = curNode.children[ch-'a'];
        }
        return curNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for(char ch:prefix.toCharArray()){
            if(curNode.children[ch-'a']==null) return false;
            curNode = curNode.children[ch-'a'];
        }
        return true;
    }
}
class TrieNode{
    boolean isWord;
    TrieNode[] children ;
    TrieNode(){
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */