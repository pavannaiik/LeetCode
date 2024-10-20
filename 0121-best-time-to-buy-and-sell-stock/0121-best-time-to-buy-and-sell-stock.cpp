class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int mini = prices[0];
       // int maxi=prices[0];
        int ans=0;
        for(int price:prices){
            ans =max(ans,price-mini);
            mini=min(mini,price);
        }
        return ans;
    }
};