class Solution {
    int maxLen = Integer.MIN_VALUE;
    int leftIndex=0, rightIndex =0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            findLP(s, i, i);
            findLP(s,i,i+1);
        }
        return s.substring(leftIndex, rightIndex+1);
    }
    public void findLP(String s, int left, int right){
        int n = s.length();
        while(left >=0 && right <n){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        int curLen = right-left-1;
        if(curLen > maxLen){
            maxLen = curLen;
            leftIndex = left+1;
            rightIndex = right-1;
        }
    }
}