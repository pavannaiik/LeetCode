class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j= s.length()-1;
        while( i<=j && j >=0 && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        if(i==j) return true;
        return isPalindrome(s, i, j-1) || isPalindrome(s,i+1, j);
    }
    public boolean isPalindrome(String s, int i, int j){
       while(i <= j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;
       }
       return true;
    }
}