class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 0;

        while (right < n) {
            hashmap.put(s.charAt(right), right++);
            if (hashmap.size() == k+1) {
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}