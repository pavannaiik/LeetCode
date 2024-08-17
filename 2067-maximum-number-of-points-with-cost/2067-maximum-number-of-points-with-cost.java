class Solution {
    long ans = Long.MIN_VALUE;
    
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[] currentRow = new long[m];
        long[] previousRow = new long[m];
        for(int[] row:points){
            long runningMax =0;
            for(int col=0;col<m;col++){
                runningMax = Math.max(runningMax-1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax=0;
            for(int col=m-1;col>=0;col--){
                runningMax = Math.max(runningMax-1, previousRow[col]);
                currentRow[col]= Math.max(currentRow[col],runningMax)+row[col];
                previousRow = currentRow;

            }
            
            
        }
        long maxPoints =0;
        for(int col=0;col<m;col++){
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }
        return maxPoints;
    }
}
