class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tG = 0, tC = 0;

        for (int i = 0; i < n; ++i) {
            tG += gas[i];
            tC += cost[i];
        }
        if (tG < tC)
            return -1;

        int currGas = 0;
        int s = 0;

        for (int i = 0; i < n; ++i) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                currGas = 0;
                s = i + 1;
            }
        }

        return s;
    }
}