class Solution {
    int[][] memo ;
    public int numDistinct(String s, String t) {
        if(s.equals(t)) return 1;
        memo = new int[s.length()+1][t.length()+1];
        for (int[] row : memo) {
        Arrays.fill(row, -1);
    }
        return countSame(s, t, 0, 0,new StringBuilder());
    }
    public int countSame(String s, String t, int sIndex,int tIndex, StringBuilder sb ){
        
        if(tIndex == t.length()) return 1;
        if(sIndex==s.length()) return 0;
        if(memo[sIndex][tIndex]!=-1) return memo[sIndex][tIndex];
        int cnt =0;
        if(s.charAt(sIndex)==t.charAt(tIndex)){
            cnt += countSame(s, t, sIndex+1, tIndex+1, sb);
        }
         cnt += countSame(s, t, sIndex+1, tIndex, sb);
        

        return memo[sIndex][tIndex]=cnt;
    }
}