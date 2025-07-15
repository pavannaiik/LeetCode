import java.util.*;

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
            if (a.freq == b.freq) return a.sentence.compareTo(b.sentence);
            return b.freq - a.freq;
        });

        for (Map.Entry<String, Integer> entry : currentNode.sentences.entrySet()) {
            pq.offer(new SentenceFreq(entry.getKey(), entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 3) {
            result.add(pq.poll().sentence);
            count++;
        }
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
