class WordDictionary {
    class TrieNode {
    public:
        vector<TrieNode*> trie;
        bool isEnd;
        
        TrieNode() : trie(26, nullptr), isEnd(false) {}
    };
    
public:
    TrieNode* root;

    WordDictionary() {
        root = new TrieNode();
    }

    void addWord(string word) {
        TrieNode* node = root;
        for (char c : word) {
            if (node->trie[c - 'a'] == nullptr) {
                node->trie[c - 'a'] = new TrieNode();
            }
            node = node->trie[c - 'a'];  // Move to the next node
        }
        node->isEnd = true;  // Mark the end of the word
    }

    bool search(string word) {
        return searchHelper(word, 0, root);
    }

private:
    // Helper function to perform recursive search with support for '.'
    bool searchHelper(const string& word, int index, TrieNode* node) {
        if (index == word.size()) {
            return node->isEnd;
        }
        
        char c = word[index];
        
        if (c == '.') {
            // If the current character is '.', check all possible children
            for (TrieNode* child : node->trie) {
                if (child != nullptr && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Normal character: just go to the next node
            TrieNode* nextNode = node->trie[c - 'a'];
            return nextNode != nullptr && searchHelper(word, index + 1, nextNode);
        }
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
