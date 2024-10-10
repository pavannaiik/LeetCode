class Solution {
    public int minAddToMakeValid(String s) {
        int left=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++;
            }else {
                if(left >0){
                    left--;
                }else{
                    ans++;
                }
            }
            
        }
        return ans+left;
    }
}