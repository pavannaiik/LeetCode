class Solution {
    public boolean checkValidString(String s) {
        int left=0, right=0;
        int n =s.length()-1;
        for(int i=0;i<=n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                left++;
            }else{
                left--;
            }
            if(s.charAt(n-i)==')' || s.charAt(n-i)=='*'){
                right++;
            }else{
                right--;
            }
            if(left <0 || right<0){
                return false;
            }
        }
        return true;
    }
}