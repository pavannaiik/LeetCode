class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int index=0;
        while(index < word1.length() || index < word2.length()){
            if(index < word1.length())
            res.append(word1.charAt(index));
            if(index < word2.length())
            res.append(word2.charAt(index));
            index ++;
        }
        return res.toString();
    }
}