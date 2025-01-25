class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Add characters to a max heap based on their frequencies
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> frequencyMap.get(b) - frequencyMap.get(a)
        );
        maxHeap.addAll(frequencyMap.keySet());

        // Step 3: Reorganize the string
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            // Get the two most frequent characters
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            // Append them to the result
            result.append(first);
            result.append(second);

            // Decrease their frequency and re-add them to the heap if they're still needed
            frequencyMap.put(first, frequencyMap.get(first) - 1);
            frequencyMap.put(second, frequencyMap.get(second) - 1);
            if (frequencyMap.get(first) > 0) {
                maxHeap.add(first);
            }
            if (frequencyMap.get(second) > 0) {
                maxHeap.add(second);
            }
        }

        // If one character is left, check if it can be placed without violating the condition
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (frequencyMap.get(last) > 1) {
                return ""; // Not possible to rearrange
            }
            result.append(last);
        }

        return result.toString();
    }
}