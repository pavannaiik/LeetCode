class Solution {
    public boolean makePalindrome(String s) {
        int cnt=0;
        int i=0, j= s.length()-1;
        while(i < j){
            if(s.charAt(i)!=s.charAt(j)) cnt++;
            i++;
            j--;
        }
        return cnt<=2;
    }
}