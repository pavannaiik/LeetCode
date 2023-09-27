class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        String res = "";
        int diff = numRows*2-2;
        for(int i=0;i<numRows;i++){
            int index = i;
            while(index<s.length()){
                res+=s.charAt(index);
                if(i !=0 && i != numRows-1){
                    int diagonalDiff = diff- 2*i;
                    int secondIndex = index + diagonalDiff;
                    if(secondIndex < s.length()){
                        res+=s.charAt(secondIndex);
                    }
                }
                index+=diff;
            }
        }
        return res;
    }
}