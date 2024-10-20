class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<pair<int,int>>stack;
        int max_area=0;
        int n = heights.size();
        for(int i=0;i<heights.size();i++){
            int ind=-1;
            while(!stack.empty() && stack.top().second > heights[i]){
                int idx= stack.top().first;
                int ht=stack.top().second;
                stack.pop();
                int area = ht*(i-idx);
                max_area = max(max_area, area);
                ind=idx;

            }
            if(ind==-1){
                stack.push({i,heights[i]});
            }else{
                stack.push({ind,heights[i]});
            }
        }
        while(!stack.empty()){
            int idx= stack.top().first;
            int ht=stack.top().second;
            stack.pop();
            int area = ht*(n-idx);
            max_area = max(max_area, area);
        }
        return max_area;
    }
};