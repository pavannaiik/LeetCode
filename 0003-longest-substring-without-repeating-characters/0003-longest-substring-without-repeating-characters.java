class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0, right=0;
        int maxLen = 0;
        HashSet<Character>set = new HashSet<>();
        for(char ch: s.toCharArray()){
          while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left));
            left++;
          }
          set.add(ch);
          right++;
          int curLen = right-left;
          maxLen = Math.max(curLen, maxLen);
        }
        return maxLen;
    }
}