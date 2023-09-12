class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res ="";
        int index=0;
        while(index < word1.length() && index < word2.length()){
            res+=word1.charAt(index);
            res+=word2.charAt(index);
            index ++;
        }
        while(index<word1.length() ){
            res+=word1.charAt(index);
            index++;
        }
        while(index<word2.length() ){
            res+=word2.charAt(index);
            index++;
        }
        return res;
    }
}