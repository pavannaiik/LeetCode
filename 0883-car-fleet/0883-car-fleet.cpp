class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,double>>combined;
        for(int i=0;i<position.size();i++){
            double time = (double)(target - position[i]) / speed[i];
            combined.push_back({position[i],time});
        }
        sort(combined.rbegin(),combined.rend());
        int carFleet =0;
        double lastTime=0;
        for(int i=0;i<combined.size();i++){
            double curTime = combined[i].second;
            if(curTime > lastTime){
                lastTime=curTime;
                carFleet ++;
            } 
        }
        return carFleet;
    }
};