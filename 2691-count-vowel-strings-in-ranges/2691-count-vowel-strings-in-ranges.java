class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = words[i];
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
                count++;
            }
            prefixSum[i] = count;
        }


        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (start == 0) {
                result[i] = prefixSum[end];
            } else {
                result[i] = prefixSum[end] - prefixSum[start - 1];
            }
        }

        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
