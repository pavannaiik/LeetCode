class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        boolean isPalin = true;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                isPalin = checkPalindrome( i, j-1, s) ||checkPalindrome( i+1, j, s) ;
                break;
            }
        }
        return isPalin;
    }
    public boolean checkPalindrome(int i, int j, String s){
        if(i>s.length() || j<0) return false;
        while(i <= j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}