class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int tGas=0,tCost=0,cGas=0;
        int start=0;
        for(int i=0;i<gas.size();i++){
            tGas+=gas[i];
            tCost+=cost[i];
            cGas +=gas[i]-cost[i];
            if(cGas<0){
                cGas=0;
                start=i+1;
            }
        }
        if(tGas < tCost) return -1;
        return start;
    }
};