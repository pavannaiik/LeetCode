class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] charMap = new int[123];
        for(char c : t.toCharArray()){
            charMap[c]++;
        }
        int right =0;
        int minLen = Integer.MAX_VALUE;
        int left =0, start =0;
        int required = t.length();
        while( right < n){
            char rightChar = s.charAt(right++);
            if(charMap[rightChar]-- > 0) required--;
            while(required ==0){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                int leftChar = s.charAt(left++);
                if(charMap[leftChar]++ ==0) required++;
            }
        }
        return minLen == Integer.MAX_VALUE?"": s.substring(start, start+minLen);
    }
}