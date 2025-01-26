
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Step 1: Calculate the maximum frequency of each letter across all words in words2
        int[] maxWord2Count = new int[26];
        for (String word : words2) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxWord2Count[i] = Math.max(maxWord2Count[i], count[i]);
            }
        }

        // Step 2: Iterate through words1 and check if each word is a universal word
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] word1Count = new int[26];
            for (char c : word.toCharArray()) {
                word1Count[c - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (word1Count[i] < maxWord2Count[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word);
            }
        }

        return result;
    }
}
