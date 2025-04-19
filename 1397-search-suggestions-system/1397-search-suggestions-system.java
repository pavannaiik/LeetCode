class Solution {
    private final Trie root = new Trie();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // lexicographic sort

        // Step 1: Build Trie
        for (String word : products) {
            Trie node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new Trie();
                node = node.children[idx];
                node.suggestions.add(word); // Store for every prefix
                if (node.suggestions.size() > 3) {
                    node.suggestions.sort(String::compareTo);
                    node.suggestions = node.suggestions.subList(0, 3); // trim to top 3
                }
            }
            node.isWord = true;
        }

        // Step 2: Search Suggestions
        List<List<String>> result = new ArrayList<>();
        Trie node = root;
        for (char ch : searchWord.toCharArray()) {
            int idx = ch - 'a';
            if (node != null) {
                node = node.children[idx];
            }
            result.add(node == null ? new ArrayList<>() : new ArrayList<>(node.suggestions));
        }

        return result;
    }
}

class Trie {
    Trie[] children;
    boolean isWord;
    List<String> suggestions;

    Trie() {
        this.children = new Trie[26];
        this.isWord = false;
        this.suggestions = new ArrayList<>();
    }
}
