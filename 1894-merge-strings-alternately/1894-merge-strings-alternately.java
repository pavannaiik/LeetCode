class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length(), m = word2.length();
        int len = Math.min(n, m);
        for(int i=0;i<len;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(len<n){
            sb.append(word1.substring(len, n));
        }
        if(len<m){
            sb.append(word2.substring(len, m));
        }
        return sb.toString();
    }
}