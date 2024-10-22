class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>ans;
        for(int i=0;i<=n;i++){
            int c=0;
            int k=i;
            while(k>0){
            c += k&1;
            k=k>>1;
          }
          ans.push_back(c);
        }
        return ans;
    }
};