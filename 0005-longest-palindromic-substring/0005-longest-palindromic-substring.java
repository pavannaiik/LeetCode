class Solution {
    int left_index=0, right_index=0, max_len=0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++){
            lps(s, i, i, n);
            lps(s, i, i+1, n);
        }
        return s.substring(left_index, right_index+1);
    }
    public void lps(String s, int i, int j, int n){
        while(i >=0 && j < n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        i++;
        j--;
        int window = j-i+1;
        if(window > max_len){
            max_len=window;
            left_index= i;
            right_index=j;
        }
    }
}