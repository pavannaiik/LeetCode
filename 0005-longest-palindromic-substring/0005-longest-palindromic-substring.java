class Solution {
    private int left =0, right =0, ans =0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++){
            longestPalin(i, i, s,n);
            longestPalin(i, i+1, s, n);
        }
        return s.substring(left, right+1);
    }
    public void longestPalin(int i, int j, String s, int n){
        while(i>=0 && j <n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        int len = j-i-1;
        if(len > ans){
            ans = len;
            left = i+1;
            right = j-1;
        }

    }
}