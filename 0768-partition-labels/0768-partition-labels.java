class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26]; // last index of each character
        int n = s.length();

        // Step 1: Fill last index of each character
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        // Step 2: Walk through the string and track partitions
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
