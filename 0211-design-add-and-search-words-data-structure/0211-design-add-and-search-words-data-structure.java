class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, TrieNode curNode){
        if(curNode == null) return false;
        if(index == word.length()) return curNode.isWord;
        char ch = word.charAt(index);
        if(ch=='.'){
            for(TrieNode children: curNode.children){
                if(children != null && dfs(word, index+1, children))
                {
                    return true;
                }

            }
            return false;
        }else{
           return dfs(word,index+1, curNode.children[ch-'a']);
        }
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */