class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Step 1: Preprocess - Build adjacency map using wildcard patterns
        Map<String, List<String>> patternMap = new HashMap<>();
        int wordLen = beginWord.length();

        for (String word : wordSet) {
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // Step 2: BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();

                for (int i = 0; i < wordLen; i++) {
                    String pattern = current.substring(0, i) + "*" + current.substring(i + 1);
                    List<String> neighbors = patternMap.getOrDefault(pattern, Collections.emptyList());

                    for (String neighbor : neighbors) {
                        if (neighbor.equals(endWord)) return level + 1;

                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
