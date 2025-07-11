class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character>set = new HashSet<>();
        int left =0;
        int longestSubStringLength =0;
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longestSubStringLength = Math.max(longestSubStringLength, right-left+1);
        }
        return longestSubStringLength;
    }
}