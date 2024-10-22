class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n=nums.size();
        vector<int>newNums(n+2,1);
        for(int i=1;i<=n;i++){
            newNums[i]=nums[i-1];
        }
        vector<vector<int>>memo(n+1,vector<int>(n+1,-1));;
        int coins= calculateMaxCoins(1,n,newNums,memo);
        return coins;
    }
    int calculateMaxCoins(int i, int j, vector<int>&newNums,  vector<vector<int>>&memo){
        if(i>j){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int maxcoins=INT_MIN;
        for(int l=i;l<=j;l++){
            int c=newNums[i-1]*newNums[l]*newNums[j+1]+calculateMaxCoins(i,l-1,newNums,memo)+calculateMaxCoins(l+1,j,newNums,memo);
            maxcoins=max(maxcoins,c);
        }
        return memo[i][j]=maxcoins;
    }
};