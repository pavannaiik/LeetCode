class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: left){
            max = Math.max(i,max);
        }
        for(int i: right){
            min = Math.min(i,min);
        }
        return Math.max(n - min,max);
    }
}