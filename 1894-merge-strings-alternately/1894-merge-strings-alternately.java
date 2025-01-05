class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i=0, j=0, m= word1.length(), n= word2.length();
        while( i <m  && j <n){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        if(i < m){
            sb.append(word1.substring(i));
        }
        if(j < n){
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
}