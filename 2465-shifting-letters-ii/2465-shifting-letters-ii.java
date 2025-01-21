class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] shiftCount= new int[n+1];
        for(int[] shift:shifts){
            int start = shift[0], end = shift[1], dir = shift[2];
            shiftCount[start] += (dir==1)?1:-1;
            shiftCount[end+1] -= (dir==1)?1:-1;
        }
        int shiftSum=0;
        for(int i=0;i<n;i++){
            shiftSum += shiftCount[i];
            int shift = ((c[i] - 'a' + shiftSum) % 26 + 26) % 26;
            c[i]= (char)('a'+shift);
        }
        return String.valueOf(c);
    }
}

