class AutocompleteSystem {
    TrieNode root;
    TrieNode curNode;
    TrieNode dead;
    StringBuilder currSentence;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for(int i=0;i<sentences.length;i++){
            addToTrie(sentences[i], times[i]);
        }
        currSentence = new StringBuilder();
        curNode = root;
        dead = new TrieNode();
    }
    
    public List<String> input(char c) {
        if(c=='#'){
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            curNode = root;
            return new ArrayList<String>();
        }
        currSentence.append(c);
        if(!curNode.children.containsKey(c)){
            curNode = dead;
            return new ArrayList<String>();
        }
        curNode = curNode.children.get(c);
        List<String> sentences = new ArrayList<>(curNode.sentences.keySet());
        Collections.sort(sentences, (a, b) -> {
            int hotA = curNode.sentences.get(a);
            int hotB = curNode.sentences.get(b);
            if (hotA == hotB) {
                return a.compareTo(b);
            }
            
            return hotB - hotA;
        });
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sentences.size()); i++) {
            ans.add(sentences.get(i));
        }
        
        return ans;
    }
    private void addToTrie(String sentence, int count){
        TrieNode node = root;
        for(char c: sentence.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0)+count);
        }
    }
}
class TrieNode{
    Map<Character, TrieNode>children;
    Map<String,Integer>sentences;
    public TrieNode(){
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
