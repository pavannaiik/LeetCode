
class AutocompleteSystem {
    TrieNode root;
    StringBuilder currentInput;
    TrieNode currentNode;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        currentInput = new StringBuilder();
        currentNode = root;

        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(currentInput.toString(), 1);
            currentInput = new StringBuilder();
            currentNode = root;
            return new ArrayList<>();
        }

        currentInput.append(c);
        if (currentNode != null) {
            currentNode = currentNode.children.getOrDefault(c, null);
        }

        if (currentNode == null) return new ArrayList<>();

        PriorityQueue<SentenceFreq> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) return b.sentence.compareTo(a.sentence); // reverse lex for min-heap
            return a.freq - b.freq; // min freq on top
        });

        for (Map.Entry<String, Integer> entry : currentNode.sentences.entrySet()) {
            SentenceFreq sf = new SentenceFreq(entry.getKey(), entry.getValue());
            pq.offer(sf);
            if (pq.size() > 3) pq.poll(); // remove lowest priority
        }

        List<String> result = new ArrayList<>();
            while (!pq.isEmpty()) result.add(pq.poll().sentence);
            Collections.reverse(result); // reverse since it’s a min-heap
            return result;
        }

    private void insert(String sentence, int times) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + times);
        }
        node.isEndOfSentence = true;
    }

    class SentenceFreq {
        String sentence;
        int freq;

        SentenceFreq(String s, int f) {
            this.sentence = s;
            this.freq = f;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> sentences = new HashMap<>();
        boolean isEndOfSentence;
    }
}
