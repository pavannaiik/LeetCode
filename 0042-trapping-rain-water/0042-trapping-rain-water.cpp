class Solution {
public:
    int trap(vector<int>& height) {
        int left_max=INT_MIN;
        int right_max =INT_MIN;
        int water=0;
        int i=0, j=height.size()-1;
        while(i<j){
            if(height[i]<=height[j]){
                left_max=max(left_max, height[i]);
                water += left_max-height[i];
                i++;
            }else{
                right_max=max(right_max, height[j]);
                water+=right_max-height[j];
                j--;
            }
        }
        return water;
    }
};