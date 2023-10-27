class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        int n =s.length();
        String s2 = sb.toString();
        for(int i=0;i<=n;i++){
            if(s.startsWith(s2.substring(i))){
                return s2.substring(0,i)+s;
            }
        }
       
        return s2+s;
    }
}