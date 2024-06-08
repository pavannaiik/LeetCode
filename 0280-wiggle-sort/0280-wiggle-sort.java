class Solution {
    public void wiggleSort(int[] nums) {
        int[] ans = new int[10001];
        for(int num:nums){
            ans[num]++;
        }
        int j=0, k=10000;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                while(j < ans.length){
                    if(ans[j]!=0){
                        nums[i]=j;
                        if(ans[j]==1)
                        j++;
                        else{
                            ans[j]--;
                        }
                        break;
                    }
                    j++;
                }
            }else{
                while(k >=0){
                    if(ans[k]!=0){
                        nums[i]=k;
                        if(ans[k]==1)
                        k--;
                        else{
                            ans[k]--;
                        }
                        break;
                    }
                    k--;
                }
            }
        }
    }
}