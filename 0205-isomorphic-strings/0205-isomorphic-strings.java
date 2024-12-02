class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        int [] tempS = new int[127];
        int [] tempT = new int[127];
        for(int i = 0; i < s.length(); i++){
            if(tempS[s.charAt(i)] != tempT[t.charAt(i)])
                return false;

            tempS[s.charAt(i)] = i + 1;
            tempT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}