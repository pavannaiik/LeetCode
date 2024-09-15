class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0;
        HashSet<Character>set = new HashSet<>();
        int j=0;
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            maxLen= Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}