class Solution {
    public int minFlipsMonoIncr(String s) {
        int flips=0, ones=0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                flips=Math.min(flips+1, ones);
            }else ones++;
        }
        return flips;
    }
}