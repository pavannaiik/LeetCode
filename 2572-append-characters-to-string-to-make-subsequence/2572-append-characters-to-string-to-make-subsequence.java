class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t))
            return 0;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int n = tCharArray.length, m = sCharArray.length;
        int j =0;
        for(int i=0;i<m;i++){
            if(sCharArray[i]== tCharArray[j]){
                j++;
            }
            if(j == n)
                return 0;
        }
        return n-j;
    }
}