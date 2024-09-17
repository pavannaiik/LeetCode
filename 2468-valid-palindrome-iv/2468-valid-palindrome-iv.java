class Solution {
    public boolean makePalindrome(String s) {
        int cnt=0;
        int i=0, j= s.length()-1;
        while(i < j){
            if(s.charAt(i)!=s.charAt(j)) cnt++;
            if(cnt >2) return false;
            i++;
            j--;
        }
        return true;
    }
}