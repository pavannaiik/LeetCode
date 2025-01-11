class Solution {
    public int maxSubstringLength(String s) {
        if (s.isBlank()) return -1;
        
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        // Step 1: Calculate first and last occurrences of each character
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (first[c - 'a'] == -1) {
                first[c - 'a'] = i;
            }
            last[c - 'a'] = i;
        }

        int res = -1;

        // Step 2: Check for self-contained substrings
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int start = first[i];
            int end = last[i];

            // Extend the substring to include all characters within the range [start, end]
            for (int j = start; j < n; j++) {
                char c = s.charAt(j);
                int charStart = first[c-'a'];
                int charEnd = last[c-'a'];
                if(charStart < start) break;
                end = Math.max(end, charEnd);

                if(j==end && end-start+1 < n){
                    res= Math.max(res, end-start+1);
                }
            }
        }

        return res;
    }
}
