class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];
        int left = 0;
        int maxWinFreq = 0 ;
        int maxLen = 0;
        for(int right = 0; right < s.length();right++){
            maxWinFreq = Math.max(maxWinFreq, ++freqArr[s.charAt(right)-'A']);
            if(right-left+1 - maxWinFreq > k){
                --freqArr[s.charAt(left)-'A'];
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}