class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank =0, curTank =0, start =0;
        for(int i=0;i<gas.length;i++){
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if(curTank < 0){
                curTank =0;
                start = i+1;
            }
        }
        return totalTank < 0? -1: start;
    }
}