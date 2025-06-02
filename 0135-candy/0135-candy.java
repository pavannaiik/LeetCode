class Solution {
    public int candy(int[] ratings) {
        int ans =ratings.length;
        int n = ratings.length;
        int[] candies = new int[ans];
        Arrays.fill(candies, 1);
        for(int i=0;i<n;i++){
            if(i-1>=0 && ratings[i]>ratings[i-1]){
                candies[i]= candies[i-1]+1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i+1<=n-1 &&  ratings[i]>ratings[i+1]){
                candies[i]= Math.max(candies[i],candies[i+1]+1);
            }
        }
        System.out.println(candies);
        return Arrays.stream(candies).sum();
    }
}