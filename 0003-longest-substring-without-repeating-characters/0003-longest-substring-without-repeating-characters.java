class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int maxLen = 0;
        HashSet<Character>set = new HashSet<>();
        for(char ch: s.toCharArray()){
          while(set.contains(ch)){
            set.remove(s.charAt(left));
            left++;
          }
          set.add(ch);
          int curLen = set.size();
          maxLen = Math.max(curLen, maxLen);
        }
        return maxLen;
    }
}