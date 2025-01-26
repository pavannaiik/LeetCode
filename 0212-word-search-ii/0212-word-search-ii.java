class Solution {
    // Trie Node
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // If this node represents the end of a word, store the word here
    }

    // Build the Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = word; // Mark the end of a word
        }
        return root;
    }

    // Backtracking function
    private void backtrack(char[][] board, int row, int col, TrieNode node, List<String> result) {
        char c = board[row][col];
        if (!node.children.containsKey(c)) {
            return; // No word with this prefix
        }

        TrieNode childNode = node.children.get(c);
        if (childNode.word != null) {
            result.add(childNode.word); // Found a word
            childNode.word = null; // Avoid duplicate entries
        }

        // Mark the cell as visited
        board[row][col] = '#';

        // Explore neighbors
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] != '#') {
                backtrack(board, newRow, newCol, childNode, result);
            }
        }

        // Restore the cell after backtracking
        board[row][col] = c;

        // Optimization: Remove the child node if it is no longer needed
        if (childNode.children.isEmpty()) {
            node.children.remove(c);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        // Step 2: Backtracking
        List<String> result = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                backtrack(board, row, col, root, result);
            }
        }

        return result;
    }
}