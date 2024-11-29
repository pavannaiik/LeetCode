class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder res = new StringBuilder();
        int charsInSection = 2*(numRows-1);
        for(int i=0;i<numRows;i++){
            int index = i;
            while(index<s.length()){
                res.append(s.charAt(index));
                if(i !=0 && i != numRows-1){
                    int charsInBetween = charsInSection- 2*i;
                    int secondIndex = index + charsInBetween;
                    if(secondIndex < s.length()){
                        res.append(s.charAt(secondIndex));
                    }
                }
                index+=charsInSection;
            }
        }
        return res.toString();
    }
}