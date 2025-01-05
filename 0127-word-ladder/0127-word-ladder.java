class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                if(!map.containsKey(newWord)){
                    map.put(newWord, new ArrayList<>());
                }
                map.get(newWord).add(word);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                for (String adjacentWord : map.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) return level + 1;
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
