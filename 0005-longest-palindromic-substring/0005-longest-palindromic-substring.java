class Solution {
     int leftIndex =0, rightIndex =0;
     int maxLen = Integer.MIN_VALUE;
    public void findLP(String s, int p, int q){
        int n =s.length();
        while(p >=0 && q < n){
            if(s.charAt(p)!=s.charAt(q)){
                break;
            }
            p--;
            q++;
        }

        int len = q-p-1;
        if(len > maxLen){
            maxLen = len;
            leftIndex = p+1;
            rightIndex = q-1;
        }
    }
    public String longestPalindrome(String s) {
        int n =s.length();
        for(int i=0;i<n;i++){
            findLP(s,i,i);
            findLP(s,i,i+1);
        }
        
        return s.substring(leftIndex,rightIndex+1);
    }
}