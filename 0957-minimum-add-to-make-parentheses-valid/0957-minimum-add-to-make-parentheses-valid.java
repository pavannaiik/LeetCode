class Solution {
    public int minAddToMakeValid(String s) {
        int left=0, right=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++;
            }else {
                right++;
            }
            if(left==right){
                left=0;
                right=0;
            }else if(right > left){
                ans+=right-left;
                right = left;
            }else if(left > right){
                left = left-right;
                right =0;
            }
        }
        return ans+left;
    }
}