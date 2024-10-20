class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
         priority_queue<int>pq;
        for(int s : stones)
            pq.push(s);
        while(pq.size()>=2){
            int y = pq.top();
            pq.pop();
            int x = pq.top();
            pq.pop();
            if(y>x){
                pq.push(y-x);
            }
        }
        return !pq.empty()?pq.top():0;
    }
};