class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int>ans(temperatures.size(),0);
        stack<int>stack;
        for(int i=0;i<temperatures.size();i++){
            while(!stack.empty() && temperatures[stack.top()] < temperatures[i]){
                int index = stack.top();
                stack.pop();
                ans[index]=i-index;
            }
            stack.push(i);
        }
        return ans;
    }
};