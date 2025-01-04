class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set = new HashSet<>();
        int i=0, j=0, n = s.length();
        int ans =0;
        while(j < n){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}