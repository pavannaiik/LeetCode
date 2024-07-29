class Solution {
    public int numTeams(int[] rating) {
        int ans=0;

        for(int j=0;j<rating.length;j++){
            int left_greater = 0, left_lesser = 0;
          for(int i=j-1;i>=0;i--){
            if(rating[i] < rating[j]){
                left_greater++;
            }else if(rating[i] > rating[j]){
                left_lesser++;
            }
          }
          int right_greater = 0, right_lesser = 0;
          for(int k=j+1;k<rating.length;k++){
            if(rating[k] < rating[j]){
                right_greater++;
            }else if(rating[k] > rating[j]){
                right_lesser++;
            }
          }
          ans += left_greater*right_lesser + left_lesser*right_greater;
        }
        return ans;

    }
}