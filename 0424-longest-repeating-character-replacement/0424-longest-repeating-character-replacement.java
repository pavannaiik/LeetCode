class Solution {
    public int characterReplacement(String s, int k) {
        int left =0, n = s.length();
        int maxLength = 0, maxCount =0;
        int[] count = new int[26];
        for(int right =0; right<n;right++){
            maxCount = Math.max(maxCount, ++count[s.charAt(right)-'A']);
            if(right-left+1 - maxCount > k){
                --count[s.charAt(left) - 'A'];
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}