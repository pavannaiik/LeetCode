class Solution {
    public String minWindow(String s, String t) {
        int[] charArray = new int[123];
        for(char ch: t.toCharArray()){
            charArray[ch]++;
        }
        int required = t.length();
        int left =0;
        int curMin = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            charArray[ch]--;
            if(charArray[ch]>=0){
                required--;
            }
            while(required == 0){
                if(curMin > i-left+1){
                    curMin = i-left+1;
                    sb = new StringBuilder(s.substring(left, i+1));
                }
                char leftChar = s.charAt(left);
                left++;
                if(charArray[leftChar]++ == 0) required++;
            }
        }
        return curMin == Integer.MAX_VALUE? "":sb.toString();
    }
}