class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        int[] leftCandles = new int[n];
        int[] rightCandles = new int[n];
        int[] totalCandles= new int[n];
        int leftC=-1, rightC=-1, totalC=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='|'){
                leftC=i;
                totalC++;
            }
            totalCandles[i]=totalC;
            leftCandles[i]=leftC;
        }
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='|'){
                rightC=i;
            }
            rightCandles[i]=rightC;
        }
        int[] res= new int[queries.length];
        int i=0;
        for(int[]query :queries){
            int left=query[0], right=query[1];
            int start = rightCandles[left];
            int end   = leftCandles[right];
            if(start==-1 || end==-1 || end-start<=1){
                res[i++]=0;
                continue;
            }
            int numberOfcandle = totalCandles[end]-totalCandles[start]+1;
            int totalSize=end-start+1;
            res[i++]=totalSize-numberOfcandle;
        }
        return res;
    }
}